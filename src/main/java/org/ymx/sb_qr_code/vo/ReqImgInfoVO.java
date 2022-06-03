package org.ymx.sb_qr_code.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.ymx.sb_qr_code.enums.ImgFormat;
import org.ymx.sb_qr_code.enums.ImgSize;

/**
 * @desc: 实体类
 * @author: YanMingXin
 * @create: 2022/6/2-20:16
 **/
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReqImgInfoVO {

    private String imgFormat;

    private String content;

    private ImgSize imgSize;

    private String logoPath;

}
