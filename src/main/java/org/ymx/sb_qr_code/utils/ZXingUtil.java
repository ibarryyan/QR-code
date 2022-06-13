package org.ymx.sb_qr_code.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.util.ObjectUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @desc: 核心工具类
 * @author: YanMingXin
 * @create: 2022/6/2-19:16
 **/
public class ZXingUtil {

    /**
     * 加密：文字->二维码（图片）
     *
     * @param imgPath 图片路径
     * @param format  图片格式 png、gif
     * @param content 需要加密的内容
     * @param width   二维码宽
     * @param height  二维码长
     * @param logo    logo图片路径
     * @throws Exception
     */
    public static void encodeImg(String imgPath, String format, String content, int width, int height, String logo) throws Exception {// format:gif
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        //设置排错率 L<M<Q<H
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
        //设置编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //外边距：margin
        hints.put(EncodeHintType.MARGIN, 1);
        //实例化BitMatrix
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        // 内存中的一张图片：此时需要的图片 是二维码-> 需要一个boolean[][] ->BitMatrix
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                img.setRGB(x, y, (bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB()));
            }
        }
        //画logo
        if (!ObjectUtils.isEmpty(logo)) {
            img = LogoUtil.logoMatrix(img, logo);
        }
        File file = new File(imgPath);
        ImageIO.write(img, format, file);
    }


    /**
     * 解密
     *
     * @param file
     * @throws Exception
     */
    public static String decodeImg(File file) throws Exception {
        if (!file.exists()) {
            return null;
        }
        BufferedImage img = ImageIO.read(file);
        MultiFormatReader formatReader = new MultiFormatReader();
        LuminanceSource source = new BufferedImageLuminanceSource(img);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
        Map map = new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        Result result = formatReader.decode(binaryBitmap, map);
        return result.toString();
    }

}
