package org.ymx.sb_qr_code.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ymx.sb_qr_code.enums.ImgSize;
import org.ymx.sb_qr_code.service.ZXingService;
import org.ymx.sb_qr_code.vo.ReqImgInfoVO;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @desc: API
 * @author: YanMingXin
 * @create: 2022/6/2-19:22
 **/
@RestController
@CrossOrigin
public class ZXingController {

    @Autowired
    private ZXingService zXingService;

    @Value("${file.upload.path}")
    private String filePath;


    @RequestMapping("/encodeImg")
    public String encodeImg(@RequestParam("content") String content,
                            @RequestParam("format") String format,
                            @RequestParam("logo") String logo,
                            @RequestParam("size") ImgSize size) {
        ReqImgInfoVO req = new ReqImgInfoVO();
        req.setContent(content)
                .setImgFormat(format)
                .setLogoPath(logo)
                .setImgSize(size);
        String img = zXingService.encodeImg(req.getImgFormat(), req.getContent(), req.getImgSize().getWidth(), req.getImgSize().getHeight(), req.getLogoPath());
        return img;
    }

    @RequestMapping(value = "/decodeImg", produces = "application/json;charset=utf-8")
    public Object decodeImg(@RequestParam("file") MultipartFile file) {
        String path = uploadLogo(file);
        // 定义上传文件保存路径
        File filepath = new File(filePath + path);
        String content = zXingService.decodeImg(filepath);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("res", content);
        map.put("img", path);
        return map;
    }

    @RequestMapping("/uploadLogo")
    public String uploadLogo(@RequestParam("file") MultipartFile file) {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //生成新的文件名称
        String newImgName = UUID.randomUUID() + suffixName;
        // 新建文件
        File filepath = new File(filePath, newImgName);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(filePath + File.separator + newImgName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newImgName;
    }


}
