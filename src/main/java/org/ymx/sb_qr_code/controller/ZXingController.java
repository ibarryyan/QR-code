package org.ymx.sb_qr_code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.ymx.sb_qr_code.service.ZXingService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @desc: API
 * @author: YanMingXin
 * @create: 2022/6/2-19:22
 **/
@RestController
public class ZXingController {

    @Autowired
    private ZXingService zXingService;

    /**
     * 上传地址
     */
    @Value("${file.upload.path}")
    private String filePath;


    @RequestMapping("/encodeImg")
    public String encodeImg(@RequestParam("content") String content) {
        String img = zXingService.encodeImg("", content, 1000, 1000, "");
        return img;
    }

    @RequestMapping("/decodeImg")
    public String decodeImg() {
        return null;
    }

    @RequestMapping("/uploadLogo")
    public String uploadLogo(@RequestParam("file") MultipartFile file) {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 定义上传文件保存路径
        String path = filePath + "images/";
        //生成新的文件名称
        String newImgName = UUID.randomUUID().toString() + suffixName;
        // 新建文件
        File filepath = new File(path, newImgName);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + newImgName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/images/images/" + newImgName;
    }

}
