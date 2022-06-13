package org.ymx.sb_qr_code.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @desc: logo Util
 * @author: YanMingXin
 * @create: 2022/6/2-19:17
 **/
public class LogoUtil {

    /**
     * 增加logo
     *
     * @param matrixImage 二维码
     * @param logo        logo图片路径
     * @return
     * @throws IOException
     */
    public static BufferedImage logoMatrix(BufferedImage matrixImage, String logo) throws IOException {
        //画logo
        Graphics2D g2 = matrixImage.createGraphics();
        //String->BufferedImage(内存)
        BufferedImage logoImg = ImageIO.read(new File(logo));
        int height = matrixImage.getHeight();
        int width = matrixImage.getWidth();
        //logo图片
        g2.drawImage(logoImg, width * 2 / 5, height * 2 / 5, width * 1 / 5, height * 1 / 5, null);
        //产生一个 画 白色圆角正方形的 画笔
        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        //将画板-画笔 关联
        g2.setStroke(stroke);
        //创建一个正方形
        RoundRectangle2D.Float round = new RoundRectangle2D.Float(width * 2 / 5, height * 2 / 5, width * 1 / 5,
                height * 1 / 5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setColor(Color.WHITE);
        g2.draw(round);
        //灰色边框
        BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(stroke2);
        //创建一个正方形
        RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(width * 2 / 5 + 2, height * 2 / 5 + 2,
                width * 1 / 5 - 4, height * 1 / 5 - 4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setColor(Color.GRAY);
        g2.draw(round2);
        g2.dispose();
        matrixImage.flush();
        return matrixImage;
    }
}
