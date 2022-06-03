package org.ymx.sb_qr_code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ymx.sb_qr_code.service.ZXingService;

/**
 * @desc: API
 * @author: YanMingXin
 * @create: 2022/6/2-19:22
 **/
@RestController
public class ZXingController {

    @Autowired
    private ZXingService zXingService;

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
    public String uploadLogo() {

        return null;
    }

}
