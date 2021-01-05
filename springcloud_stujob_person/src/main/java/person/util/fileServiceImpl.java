package person.util;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service("fileServiceImpl")
public class fileServiceImpl {


    /**
     *
     * @param fileSrc
     * @param file
     * 存储单个文件
     */
    public void saveOneFile(String fileSrc, MultipartFile file)
            throws IOException {
        fileSrc="file/"+file.getOriginalFilename();
        FileUtils.copyInputStreamToFile(file.getInputStream(),
                new File("springcloud_stujob_person/src/main/resources/static/"+fileSrc));
        FileUtils.copyInputStreamToFile(file.getInputStream(),
                new File("springcloud_stujob_searchorchat/src/main/resources/static/"+fileSrc));
        FileUtils.copyInputStreamToFile(file.getInputStream(),
                new File("springcloud_stujob_autorecommendorstudynamic/src/main/resources/static/"+fileSrc));
    }
}
