/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : blogdb

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-08-06 15:26:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleid` int(100) NOT NULL AUTO_INCREMENT,
  `articletitle` varchar(500) DEFAULT NULL,
  `articlecontent` varchar(2000) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `loveamount` int(100) DEFAULT NULL,
  PRIMARY KEY (`articleid`),
  KEY `article_user` (`userid`),
  CONSTRAINT `article_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'input禁止输入的方法', '其实在jquery里把字符串转换为数字，用的还是js，因为jquery本身就是用js封装编写的。\n\n比如我们在用jquery里的ajax来更新文章的阅读次数或人气的时候，就需要用到字符串转换为数字的功能了，\n\n先来看看JS里把字符串转换为数字的函数命令：\n\n1：parseInt(string) ： 这个函数的功能是从string的开头开始解析，返回一个整数，说起来比较笼统，下面来看几个实例，大家就明白了：\n\n\nparseInt(\"1234blue\"); //returns 1234\nparseInt(\"123\"); //returns 123\nparseInt(\"22.5\"); //returns 22\nparseInt(\"blue\"); //returns NaN\n \n//另外parseInt()方法还有基模式，就是可以把二进制、八进制、十六进制或其他任何进制的字符串转换成整数。基是由parseInt()方法的第二个参数指定的，示例如下：\nparseInt(\"AF\", 16); //returns 175\nparseInt(\"10\", 2); //returns 2\nparseInt(\"10\", 8); //returns 8\nparseInt(\"10\", 10); //returns 10\n \n如果十进制数包含前导0，那么最好采用基数10，这样才不会意外地得到八进制的值。例如：\nparseInt(\"010\"); //returns 8\nparseInt(\"010\", 8); //returns 8\nparseInt(\"010\", 10); //returns 10\n2:parseFloat()：这个函数与parseInt()方法的处理方式相似。\n使用parseFloat()方法的另一不同之处在于，字符串必须以十进制形式表示浮点数，parseFloat()没有基模式。\n\n\nparseFloat(\"1234blue\"); //returns 1234.0\nparseFloat(\"0xA\"); //returns NaN\nparseFloat(\"22.5\"); //returns 22.5\nparseFloat(\"22.34.5\"); //returns 22.34\nparseFloat(\"0908\"); //returns 908\nparseFloat(\"blue\"); //returns NaN\n3：Number()：强制类型转换，与parseInt()和parseFloat()方法的处理方式相似，只是它转换的是整个值，而不是部分值。\n\nNumber(false) 0\nNumber(true) 1\nNumber(undefined) NaN\nNumber(null) 0\nNumber( \"5.5 \") 5.5\nNumber( \"56 \") 56\nNumber( \"5.6.7 \") NaN\nNumber(new Object()) NaN\nNumber(100) 100  ', '1', '2020.7.23', '18');
INSERT INTO `article` VALUES ('2', 'Mybatis中的update动态SQL语句', 'Mybatis中的CRUD操作（增删改查）中，简单的SQL操作比较直观，如查找操作：\r\n\r\n<select id=\"findBySrcId\" resultMap=\"entityRelationResultMap\">\r\n  SELECT * FROM ENTITY_RELATION WHERE SRC_ID=#{srcId}\r\n</select>\r\n其中id对应同名java文件中的方法，resultMap对应的自定义的数据类型（当使用java自带类型就更容易了，比如java.lang.String之类的）。\r\n\r\n但是涉及到更新操作时，可能不需要对所有字段更新，这时不需要更新的字段需要保持原字段信息，当使用以下信息就会报错：\r\n\r\n<update id=\"updateOne\"  parameterType=\"com.inspur.search.data.EntityRelation\">\r\n update ENTITY_RELATION SET SRC_ID=#{srcId},SRC_TYPE=#{srcType},DEST_ID=#{destId},\r\n        DEST_TYPE=#{destType},REL_TYPE=#{relType},STATUS=#{status},SN_ID=#{snId}\r\n where id=#{id}\r\n</update>\r\n因为不更新的字段，会被传递null到SQL中，引起异常。\r\n\r\n这时就需要进行动态SQL拼接，如下，使用trim就是为了删掉最后字段的“,”。\r\n主要不用单独写SET了，因为set被包含在trim中了：\r\n\r\n<update id=\"updateOne\"  parameterType=\"com.inspur.search.data.EntityRelation\">\r\n UPDATE ENTITY_RELATION\r\n <trim prefix=\"set\" suffixOverrides=\",\">\r\n  <if test=\"srcId!=null\">SRC_ID=#{srcId},</if>\r\n  <if test=\"srcType!=null\">SRC_TYPE=#{srcType},</if>\r\n  <if test=\"destId!=null\">DEST_ID=#{destId},</if>\r\n  <if test=\"destType!=null\">DEST_TYPE=#{destType},</if>\r\n  <if test=\"relType!=null\">REL_TYPE=#{relType},</if>\r\n  <if test=\"status!=null\">STATUS=#{status},</if>\r\n  <if test=\"snId!=null\">SN_ID=#{snId},</if>\r\n </trim>\r\n WHERE id=#{id}\r\n</update>', '1', '2020.7.2', '2');
INSERT INTO `article` VALUES ('3', 'Ajax跨域访问出现Uncaught SyntaxError: Unexpected token : 解决方案', '在访问外网提供的Api时出现跨域问题，尝试使用普通方式JSONP解决，但是出现Uncaught SyntaxError: Unexpected token : 的错误，所有专注于研究ajax请求跨域问题，在前人基础上逐渐理出脉络，以此记之，希望对大家有所帮助。搜罗资源比较杂乱，所有看到“撒网要见鱼”的一篇文章，下面的内容以此为蓝本，加入自己的总结。感谢“撒网要见鱼”。\r\n\r\n关于跨域，有N种类型，本文只专注于ajax请求跨域(ajax跨域只是属于浏览器\"同源策略\"中的一部分,其它的还有Cookie跨域iframe跨域,LocalStorage跨域等)。\r\n\r\n本文大纲如下：\r\n\r\n什么是ajax跨域\r\n原理\r\n表现(整理了一些遇到的问题以及解决方案)\r\n如何解决ajax跨域\r\nJSONP方式\r\nCORS方式\r\n代理请求方式\r\n如何分析ajax跨域\r\nhttp抓包的分析\r\n一些示例\r\n什么是ajax跨域\r\najax跨域的原理\r\najax出现请求跨域错误问题,主要原因就是因为浏览器的“同源策略”,可以参考\r\n浏览器同源政策及其规避方法(阮一峰)\r\n\r\nCORS请求原理\r\nCORS是一个W3C标准，全称是\"跨域资源共享\"（Cross-origin resource sharing）。它允许浏览器向跨源服务器，发出XMLHttpRequest请求，从而克服了AJAX只能同源使用的限制。\r\n\r\n基本上目前所有的浏览器都实现了CORS标准,其实目前几乎所有的浏览器ajax请求都是基于CORS机制的,只不过可能平时前端开发人员并不关心而已(所以说其实现在CORS解决方案主要是考虑后台该如何实现的问题)。\r\n\r\n关于CORS，强烈推荐阅读\r\n跨域资源共享 CORS 详解(阮一峰)\r\n\r\n另外，这里也整理了一个实现原理图(简化版):\r\n\r\n这里写图片描述\r\n\r\n如何判断是否是简单请求?\r\n浏览器将CORS请求分成两类：简单请求（simple request）和非简单请求（not-so-simple request）。只要同时满足以下两大条件，就属于简单请求。\r\n\r\n请求方法是以下三种方法之一：HEAD,GET,POST\r\nHTTP的头信息不超出以下几种字段：\r\nAccept\r\nAccept-Language\r\nContent-Language\r\nLast-Event-ID\r\nContent-Type(只限于三个值application/x-www-form-urlencoded、 multipart/form-data、text/plain)\r\n凡是不同时满足上面两个条件，就属于非简单请求。\r\nCORS实现跨域请求，是通过服务器端配置的，不属于我们要探讨的引用网外API方式出现的问题。不过基于CORS是目前只要解决方案，下面有详细的配置方式。', '2', '2020.7.2', '0');
INSERT INTO `article` VALUES ('4', '软件开发人员行动指南：5年从业者的经验之谈', '        我们常常说过程比结果更重要，那是因为在开发软件过程中遇到的成功或是失败，我们都将收获很多东西。\n\n从业五年后，我想跟大家讲讲，我作为软件开发人员的成长道路和收获的那些经验。\n\n高效地学习\n\n作为一名开发人员，高效地学习非常重要。我们当然可以从其他方法中获得成长，但亲自实践是最好不过的方法了。\n\n我们编写软件来解决问题，而解决问题需要更多的实践。要学会分配学习时间，不必将时间都用来写代码。\n\n在动手实践之前应该阅读一些指导手册和文档，这样我们才能找到正确的开始方向。一次只学一点点就行，没必要太着急。大多数情况下，小的概念更容易学习，先从简单基本的概念开始，然后再攻克更难、更高深的知识，循序渐进。\n\n过时的技术就不用再学习了。之所以过时，是因为它们已经不再有用，或者它们是通过一些不良实践途径实现的。我们要像它们的开发者那样舍弃它们。\n\n学习很重要，更重要的是坚持。\n\n\n\n图源：unsplash\n\n善于记录\n\n记录是一个好习惯，有助于记忆和交流。\n\n我们通常会将会议的决定写下来，包括正在进行的工作和接下来必须要做的工作。此外，还有在软件开发过程中遇到的任何问题也应该记下来，比如失败、紧急情况以及解决和预防方案。\n\n以后会用到的代码段也需要记录下来，以便在需要的时候找出来看看。\n\n \n\n避免无聊的琐事\n\n任何无聊和重复的事情都交给自动化，例如备份、测试、构建、部署等。\n\n如果想看新闻，可以把它们放在RSS阅读器里打开，这样可以避免广告。如果我们想尝试一些新东西，只要看看这个页面上有什么新鲜的，或者看看Github上最受欢迎的存储库就可以了。\n\n安全性\n\n安全对于任何应用程序都很重要。我们需要确保知道如何防止常见的攻击，如跨站点脚本攻击、跨站点请求伪造、SQL注入、反序列化攻击等等。新的威胁不断出现，攻击者不会停止攻击行为，我们必须多加注意。\n\n \n\n\n\n图源：unsplash\n\n重构\n\n在安全地重构代码之前，需要进行一些单元测试来检测重构后的代码是否仍然像以前那样工作。可以用单元测试和一些手动测试来检测代码，看看哪里有错误。手动测试通常用于还没有单元测试的新特性检测上。\n\n决策\n\n做决策时常有的事，不仅仅是写代码，还有我们必须做出的其他决定。\n\n做决策之前多去听听队友的意见，还要考虑到商业因素，如果这些决定对公司有益，或者是我们需要做的事情，那么放手去做就好。\n\n \n\n保持开放的心态\n\n保持开放的思想才能吸收各种想法。每个人都有自己的想法，要去聆听和吸收别人的看法。他们的经验对我们来说也很有价值，因为每个人的经验和专长都不同。\n\n\n\n图源：unsplash\n\n沟通\n\n \n\n决定一个团队成功与否的必要条件是沟通。我们必须确保每个人方向一致，这样可以避免很多问题。\n\n沟通指的是为了满足客户需求需要倾听客户的意见，以及互相尊重和互相理解。这些在软件开发中非常重要。我们不应该把反馈看得太个人化，而应该把它们看作是一个宝贵的学习机会。\n\n \n\n作为一名开发人员，我们要做的不仅仅是写代码。要考虑他人，要考虑整体，在不断的实践中你会发现，开发人员的工作包罗万象，其乐无穷。', '1', '2020.7.24', '1');
INSERT INTO `article` VALUES ('5', '程序员必备基础：Git 命令全方位学习', '        前言\n掌握Git命令是每位程序员必备的基础，之前一直是用smartGit工具，直到看到大佬们都是在用Git命令操作的，回想一下，发现有些Git命令我都忘记了，于是写了这篇博文，复习一下~\n\nhttps://github.com/whx123/JavaHome\n\n公众号：捡田螺的小男孩\n\n文章目录\n\nGit是什么?\nGit的相关理论基础\n日常开发中，Git的基本常用命令\nGit进阶之分支处理\nGit进阶之处理冲突\nGit进阶之撤销与回退\nGit进阶之标签tag\nGit其他一些经典命令\nGit是什么\n在回忆Git是什么的话，我们先来复习这几个概念哈~\n\n什么是版本控制？\n百度百科定义是酱紫的~\n\n版本控制是指对软件开发过程中各种程序代码、配置文件及说明文档等文件变更的管理，是软件配置管理的核心思想之一。\n\n那些年，我们的毕业论文,其实就是版本变更的真实写照…脑洞一下，版本控制就是这些论文变更的管理~\n\n\n什么是集中化的版本控制系统？\n那么，集中化的版本控制系统又是什么呢，说白了，就是有一个集中管理的中央服务器，保存着所有文件的修改历史版本，而协同开发者通过客户端连接到这台服务器，从服务器上同步更新或上传自己的修改。\n\n\n\n什么是分布式版本控制系统？\n分布式版本控制系统，就是远程仓库同步所有版本信息到本地的每个用户。嘻嘻，这里分三点阐述吧：\n\n用户在本地就可以查看所有的历史版本信息，但是偶尔要从远程更新一下，因为可能别的用户有文件修改提交到远程哦。\n用户即使离线也可以本地提交，push推送到远程服务器才需要联网。\n每个用户都保存了历史版本，所以只要有一个用户设备没问题，就可以恢复数据啦~\n\n\n什么是Git?\nGit是免费、开源的分布式版本控制系统，可以有效、高速地处理从很小到非常大的项目版本管理。\n\n\n\nGit的相关理论基础\nGit的四大工作区域\nGit的工作流程\nGit文件的四种状态\n一张图解释Git的工作原理\nGit的四大工作区域\n先复习Git的几个工作区域哈：\n\n\nWorkspace：你电脑本地看到的文件和目录，在Git的版本控制下，构成了工作区。\nIndex/Stage：暂存区，一般存放在 .git目录下，即.git/index,它又叫待提交更新区，用于临时存放你未提交的改动。比如，你执行git add，这些改动就添加到这个区域啦。\nRepository：本地仓库，你执行git clone 地址，就是把远程仓库克隆到本地仓库。它是一个存放在本地的版本库，其中HEAD指向最新放入仓库的版本。当你执行git commit，文件改动就到本地仓库来了~\nRemote：远程仓库，就是类似github，码云等网站所提供的仓库，可以理解为远程数据交换的仓库~\nGit的工作流程\n上一小节介绍完Git的四大工作区域，这一小节呢，介绍Git的工作流程咯，把git的操作命令和几个工作区域结合起来，个人觉得更容易理解一些吧，哈哈，看图：\n\n\ngit 的正向工作流程一般就这样：\n\n从远程仓库拉取文件代码回来；\n在工作目录，增删改查文件；\n把改动的文件放入暂存区；\n将暂存区的文件提交本地仓库；\n将本地仓库的文件推送到远程仓库；\nGit文件的四种状态\n根据一个文件是否已加入版本控制，可以把文件状态分为：Tracked(已跟踪)和Untracked(未跟踪)，而tracked(已跟踪)又包括三种工作状态：Unmodified，Modified，Staged\n\n\n\nUntracked: 文件还没有加入到git库，还没参与版本控制，即未跟踪状态。这时候的文件，通过git add 状态，可以变为Staged状态\nUnmodified：文件已经加入git库, 但是呢，还没修改, 就是说版本库中的文件快照内容与文件夹中还完全一致。 Unmodified的文件如果被修改, 就会变为Modified. 如果使用git remove移出版本库, 则成为Untracked文件。\nModified：文件被修改了，就进入modified状态啦，文件这个状态通过stage命令可以进入staged状态\nstaged：暂存状态. 执行git commit则将修改同步到库中, 这时库中的文件和本地文件又变为一致, 文件为Unmodified状态.\n一张图解释Git的工作原理\n\n\n日常开发中，Git的基本常用命令\ngit clone\ngit checkout -b dev\ngit add\ngit commit\ngit log\ngit diff\ngit status\ngit pull/git fetch\ngit push\n这个图只是模拟一下git基本命令使用的大概流程哈~', '1', '2020.7.24', '1');
INSERT INTO `article` VALUES ('6', 'springboot集成普罗米修斯', '        Prometheus 是一套开源的系统监控报警框架。它由工作在 SoundCloud 的 员工创建，并在 2015 年正式发布的开源项目。2016 年，Prometheus 正式加入 Cloud Native Computing Foundation，非常的受欢迎。\n\n简介\nPrometheus 具有以下特点：\n\n一个多维数据模型，其中包含通过度量标准名称和键/值对标识的时间序列数据\nPromQL，一种灵活的查询语言，可利用此维度\n不依赖分布式存储； 单服务器节点是自治的\n时间序列收集通过HTTP上的拉模型进行\n通过中间网关支持推送时间序列\n通过服务发现或静态配置发现目标\n多种图形和仪表板支持模式\nPrometheus 组成及架构\n\n声明：该小节参考了文章[Prometheus 入门与实践]\n\nPrometheus 生态圈中包含了多个组件，其中许多组件是可选的：\n\nPrometheus Server: 用于收集和存储时间序列数据。\nClient Library: 客户端库，为需要监控的服务生成相应的 metrics 并暴露给 Prometheus server。当 Prometheus server 来 pull 时，直接返回实时状态的 metrics。\nPush Gateway: 主要用于短期的 jobs。由于这类 jobs 存在时间较短，可能在 Prometheus 来 pull 之前就消失了。为此，这次 jobs 可以直接向 Prometheus server 端推送它们的 metrics。这种方式主要用于服务层面的 metrics，对于机器层面的 metrices，需要使用 node exporter。\nExporters: 用于暴露已有的第三方服务的 metrics 给 Prometheus。\nAlertmanager: 从 Prometheus server 端接收到 alerts 后，会进行去除重复数据，分组，并路由到对收的接受方式，发出报警。常见的接收方式有：电子邮件，pagerduty，OpsGenie, webhook 等。\n一些其他的工具。\n\n\n其大概的工作流程是：\n\nPrometheus server 定期从配置好的 jobs 或者 exporters 中拉 metrics，或者接收来自 Pushgateway 发过来的 metrics，或者从其他的 Prometheus server 中拉 metrics。\nPrometheus server 在本地存储收集到的 metrics，并运行已定义好的 alert.rules，记录新的时间序列或者向 Alertmanager 推送警报。\nAlertmanager 根据配置文件，对接收到的警报进行处理，发出告警。\n在图形界面中，可视化采集数据。\nspringboot 集成prometheus\n在spring boot工程中引入actuator的起步依赖，以及micrometer-registry-prometheus的依赖。', '1', '2020.7.24', '0');
INSERT INTO `article` VALUES ('7', '新基建缘何5G打头阵？', '        疫情之下，新年伊始（2020年3月4日），中央提出，加快5G网络、大数据中心等新型基础设施建设进度。从会议召开至今，一个多月的时间内，“新基建”在产业领域，几乎成为了疫情之外的第二个热点，各种产业研究、全产业链解读等铺天盖地，其火热程度可见一斑。受国内疫情，以及来势汹汹的国外疫情影响，各个产业和行业领域均面临挑战。正值此时，国家正式推出“新基建”，引发了一场“解读新基建”的狂欢。一时间关于新基建政策解读，各界各派众说纷纭。因此，本文将尝试拨开迷雾去探索新基建政策的来龙去脉，以及5G与新基建之间的内在关联与逻辑。\n\n核心观点\n\n- 疫情导致全球经济衰退已成大概率事件，基建投资呼之欲出。遏制经济衰退，新基建难当大任，旧基建仍须“砥砺前行”；\n\n- 新基建看似“一夜爆红”，实则由来已久，疫情加速政策发布；\n\n- 5G屡屡“打头阵”，源于中国5G产业优势。\n\n| 全文8000字，预计阅读20分钟\n\n\n', '1', '2020.7.24', '0');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(100) NOT NULL AUTO_INCREMENT,
  `booktitle` varchar(500) DEFAULT NULL,
  `bookinductor` varchar(500) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  KEY `book_user` (`userid`),
  CONSTRAINT `book_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for `like`
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `likeid` int(100) NOT NULL AUTO_INCREMENT,
  `userid` int(100) DEFAULT NULL,
  `articleid` int(100) DEFAULT NULL,
  `statu` int(100) DEFAULT NULL,
  PRIMARY KEY (`likeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like
-- ----------------------------

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `replyid` int(100) NOT NULL AUTO_INCREMENT,
  `articleid` int(100) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`replyid`),
  KEY `reply_replayuser` (`userid`),
  KEY `reply_user` (`articleid`),
  CONSTRAINT `reply_replayuser` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reply_user` FOREIGN KEY (`articleid`) REFERENCES `article` (`articleid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('11', '1', '1', '你真帅');
INSERT INTO `reply` VALUES ('26', '3', '2', '第三篇文章厉害');
INSERT INTO `reply` VALUES ('27', '1', '1', '大声地说');
INSERT INTO `reply` VALUES ('28', '5', '1', '都打双打');
INSERT INTO `reply` VALUES ('31', '1', '1', '暖暖暖暖暖');
INSERT INTO `reply` VALUES ('32', '1', '1', '来来来来来');
INSERT INTO `reply` VALUES ('33', '2', '8', '1111');

-- ----------------------------
-- Table structure for `replyperson`
-- ----------------------------
DROP TABLE IF EXISTS `replyperson`;
CREATE TABLE `replyperson` (
  `replypersonid` int(100) NOT NULL AUTO_INCREMENT,
  `replyid` int(100) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `replycontent` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`replypersonid`),
  KEY `replyperson_user` (`userid`),
  KEY `replyperson_reply` (`replyid`),
  CONSTRAINT `replyperson_reply` FOREIGN KEY (`replyid`) REFERENCES `reply` (`replyid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `replyperson_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replyperson
-- ----------------------------
INSERT INTO `replyperson` VALUES ('13', '26', '2', 'admin', '棒棒哒');
INSERT INTO `replyperson` VALUES ('14', '28', '1', '符官正', '大神大神');
INSERT INTO `replyperson` VALUES ('15', '28', '1', '符官正', '大神大神');
INSERT INTO `replyperson` VALUES ('18', '31', '1', '符官正', 'dasdas');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `netname` varchar(100) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `corporation` varchar(100) DEFAULT NULL,
  `introduction` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`userid`,`username`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '符官正', '123456', '18225310924', '路向北11', '项目经理', '阿里', '非常牛逼');
INSERT INTO `user` VALUES ('2', 'admin', '123456', '18225310924', '一路向北11', '项目经理', '重庆', '好的刷卡回答说');
INSERT INTO `user` VALUES ('4', '张飞', '123456', '123456', '路向北1', '程序员', '阿里', '一般牛逼');
INSERT INTO `user` VALUES ('5', '关羽', '123456', '18225310924', '一路向北11', '百度', '百度', '菜菜');
INSERT INTO `user` VALUES ('6', '我是你捏捏', '123456', '18225310924', null, null, null, null);
INSERT INTO `user` VALUES ('7', 'fgz1', '123456', '18225310924', null, null, null, null);
INSERT INTO `user` VALUES ('8', 'fgz2', '123456', '18225310924', null, null, null, null);

-- ----------------------------
-- Table structure for `usermsg`
-- ----------------------------
DROP TABLE IF EXISTS `usermsg`;
CREATE TABLE `usermsg` (
  `msgid` int(100) NOT NULL AUTO_INCREMENT,
  `sendUser` int(100) DEFAULT NULL,
  `toUser` int(100) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`msgid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermsg
-- ----------------------------
INSERT INTO `usermsg` VALUES ('11', '5', '4', '来自:5:用户发给:4:用户的信息:来自:5用户发给4用户的信息:aaa \r\n \r\n');
