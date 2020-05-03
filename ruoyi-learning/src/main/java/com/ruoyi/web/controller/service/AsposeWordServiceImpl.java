package com.ruoyi.web.controller.service;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.learning
 * @ClassName: word转换PDF
 * @Author: 胡天霸
 * @Date: 2020/4/30 12:25
 * @Version: 1.0
 */
@Service("asposeWordService")
public class AsposeWordServiceImpl implements WordService {

    @Override
    public void word2pdf(String inPath, String outPath) throws Exception {
        Document doc = new Document(inPath);
        doc.save(outPath, SaveFormat.PDF);
    }
}
