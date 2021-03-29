package person.service.impl;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.bean.position;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class PositionElasticsearchImpl {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void addposition(String company_name,String position_demand,
                            String position_money,String position_name,
                            String position_walfare,String position_send_userphone) throws Exception{
        position p=new position();
        p.setCompany_name(company_name);
        p.setPosition_demand(position_demand);
        p.setPosition_money(position_money);
        p.setPosition_name(position_name);
        p.setPosition_walfare(position_walfare);
        p.setPosition_send_userphone(position_send_userphone);
        p.setPosition_id(UUID.randomUUID().toString().replace("-",""));
        p.setPosition_send_time(new Date().toString().substring(0,19));
        System.out.println(p);
        IndexRequest request = new IndexRequest("springcloud_company_position");
        request.timeout("1s");
        request.source(JSON.toJSONString(p), XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }
    public List<Map<String,Object>> searchPage(String keyword,int pageNo,int pageSize) throws Exception{
        SearchRequest searchRequest=new SearchRequest("springcloud_company_position");
        //		创建  搜索内容参数设置对象:SearchSourceBuilder
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        //分页
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);

        //模糊匹配
        MatchQueryBuilder positionQuery = QueryBuilders.matchQuery("position_name", keyword);
        MatchQueryBuilder companyQuery = QueryBuilders.matchQuery("company_name", keyword);
        BoolQueryBuilder shouldQuery = QueryBuilders.boolQuery().should(companyQuery).should(positionQuery);
        sourceBuilder.query(shouldQuery);

        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("position_name");
        highlightBuilder.preTags("<span style='color:red;font-size:17px'>");
        highlightBuilder.postTags("</span>");
        highlightBuilder.field("company_name");
        highlightBuilder.preTags("<span style='color:red;font-size:17px'>");
        highlightBuilder.postTags("</span>");
        sourceBuilder.highlighter(highlightBuilder);

        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        ArrayList<Map<String,Object>> list=new ArrayList<>();
        for(SearchHit hit:searchResponse.getHits().getHits()){
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            //获取高亮字段
            HighlightField position_name = highlightFields.get("position_name");
            HighlightField company_name = highlightFields.get("company_name");
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            if(position_name!=null){
                Text[] fragments = position_name.fragments();
                String new_position_name="";
                for(Text text:fragments){
                    new_position_name+=text;
                }
                sourceAsMap.put("position_name",new_position_name);//高亮替换原来的
            }
            if(company_name!=null){
                Text[] fragments = company_name.fragments();
                String new_position_name="";
                for(Text text:fragments){
                    new_position_name+=text;
                }
                sourceAsMap.put("company_name",new_position_name);//高亮替换原来的
            }
            list.add(sourceAsMap);
        }
        return list;
    }
    public HashSet<String> getpositioninfo(String position_name,String company_name,String position_send_time) throws Exception{
        SearchRequest searchRequest=new SearchRequest("springcloud_company_position");
        //		创建  搜索内容参数设置对象:SearchSourceBuilder
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();

        //精准匹配
        MatchPhraseQueryBuilder position_name1 = QueryBuilders.matchPhraseQuery("position_name", position_name);
        MatchPhraseQueryBuilder position_name2 =QueryBuilders.matchPhraseQuery("company_name", company_name);
        MatchPhraseQueryBuilder position_name3 =QueryBuilders.matchPhraseQuery("position_send_time", position_send_time);
        sourceBuilder.query(QueryBuilders.boolQuery()
        .must(position_name1)
        .must(position_name2)
        .must(position_name3));
        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse);
        HashSet<String> list=new HashSet<>();
        for(SearchHit hit:searchResponse.getHits().getHits()){
            String sourceAsString = hit.getSourceAsString();
            list.add(sourceAsString);
        }
        return list;
    }
    public String getpositionId(String position_name,String company_name,String position_send_time) throws Exception{
        SearchRequest searchRequest=new SearchRequest("springcloud_company_position");
        //		创建  搜索内容参数设置对象:SearchSourceBuilder
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();

        //精准匹配
        MatchPhraseQueryBuilder position_name1 = QueryBuilders.matchPhraseQuery("position_name", position_name);
        MatchPhraseQueryBuilder position_name2 =QueryBuilders.matchPhraseQuery("company_name", company_name);
        MatchPhraseQueryBuilder position_name3 =QueryBuilders.matchPhraseQuery("position_send_time", position_send_time);
        sourceBuilder.query(QueryBuilders.boolQuery()
                .must(position_name1)
                .must(position_name2)
                .must(position_name3));
        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        for(SearchHit hit:searchResponse.getHits().getHits()){
            String id = hit.getId();
            return id;
        }
        return null;
    }
    public String deletePostionById(String PositionId) throws Exception{
        DeleteRequest deleteRequest=new DeleteRequest("springcloud_company_position",PositionId);
        DeleteResponse deleteResponse=restHighLevelClient.delete(deleteRequest,RequestOptions.DEFAULT);
        String status=deleteResponse.status().toString();
        if(status.equalsIgnoreCase("OK")){
            return "success";
        }else {
            return "error";
        }
    }
    public HashSet<String> getpositioninfoByPhone(String phone) throws Exception{
        SearchRequest searchRequest=new SearchRequest("springcloud_company_position");
        //		创建  搜索内容参数设置对象:SearchSourceBuilder
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();

        //精准匹配
        MatchPhraseQueryBuilder position_name1 = QueryBuilders.matchPhraseQuery("position_send_userphone", phone);
        sourceBuilder.query(QueryBuilders.boolQuery()
                .must(position_name1));
        sourceBuilder.size(1000);
        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse);
        HashSet<String> list=new HashSet<>();
        for(SearchHit hit:searchResponse.getHits().getHits()){
            String sourceAsString = hit.getSourceAsString();
            list.add(sourceAsString);
        }
        return list;
    }
    public int positionchart(String position_name) throws Exception{
        SearchRequest searchRequest=new SearchRequest("springcloud_company_position");
        //		创建  搜索内容参数设置对象:SearchSourceBuilder
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        //精准匹配
        MatchQueryBuilder termQueryBuilder = QueryBuilders.matchQuery("position_name", position_name);
        sourceBuilder.query(termQueryBuilder);

        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        long value = searchResponse.getHits().getTotalHits().value;
        return (int)value;
    }
    public int getallpositioncount() throws Exception{
        SearchRequest searchRequest=new SearchRequest("springcloud_company_position");
        //		创建  搜索内容参数设置对象:SearchSourceBuilder
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        //精准匹配
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(matchAllQueryBuilder);
        sourceBuilder.size(5000);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        long value = searchResponse.getHits().getTotalHits().value;
        return (int)value;
    }
    public HashSet<String> getPositionByCompanyName(String company_name) throws Exception{
        SearchRequest searchRequest=new SearchRequest("springcloud_company_position");
        //		创建  搜索内容参数设置对象:SearchSourceBuilder
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchPhraseQuery("company_name",company_name)));
        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse);
        HashSet<String> list=new HashSet<>();
        for(SearchHit hit:searchResponse.getHits().getHits()){
            String sourceAsString = hit.getSourceAsString();
            list.add(sourceAsString);
        }
        return list;
    }
}
