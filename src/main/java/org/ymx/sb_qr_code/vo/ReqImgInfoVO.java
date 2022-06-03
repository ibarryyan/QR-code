package org.ymx.sb_qr_code.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

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

    private String format;

    private String content;

    private String size;

    private String logoPath;

}
