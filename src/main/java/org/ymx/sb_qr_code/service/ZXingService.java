package org.ymx.sb_qr_code.service;

import java.io.File;

/**
 * @desc: 加密图片和解密图片
 * @author: YanMingXin
 * @create: 2022/6/2-19:22
 **/
public interface ZXingService {

    /**
     * 加密
     *
     * @param format
     * @param content
     * @param width
     * @param height
     * @param logo
     * @return
     */
    String encodeImg(String format, String content, int width, int height, String logo);

    /**
     * 解密
     *
     * @param file
     * @return
     */
    String decodeImg(File file);


    String uploadLogo(File file);

}
