package org.ymx.sb_qr_code.enums;

/**
 * @desc: 格式枚举
 * @author: YanMingXin
 * @create: 2022/6/2-20:15
 **/
public enum ImgFormat {

    JPG("jpg"), PNG("png"), GIF("gif");

    String format;

    ImgFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return this.format;
    }

}
