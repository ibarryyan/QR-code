package org.ymx.sb_qr_code.enums;

/**
 * @desc: 图片大小枚举
 * @author: YanMingXin
 * @create: 2022/6/2-20:15
 **/
public enum ImgSize {

    MINI(80, 80), SMALL(120, 120), MIDDLE(200, 200), BIG(500, 500);

    int width;

    int height;

    ImgSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "ImgSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
