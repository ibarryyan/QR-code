## 基于Spring Boot的二维码生成与解析工具

### 0 安装运行步骤

下载：``` git clone https://github.com/ibarryyan/sb_qr_code.git ```

安装：``` mvn install ```

### 1 整体架构

![img](https://ibarryyan.oss-cn-hangzhou.aliyuncs.com/%E8%AE%BE%E8%AE%A1%E5%9B%BE.png)

### 2 注意点

- 拦截器：防刷接口
- Shell脚本：定时清除logo图片缓存

### 3 请求样例

#### 1 文字->二维码

上传Logo

```shell
POST ：http://${IP}/uploadLogo
```

```json
{
  "file": "Desktop\\QQ图片20220603175226.jpg"
}
```

生成二维码：

```shell
POST ：http://${IP}/encodeImg
```

```json
{
  "imgFormat": "jpg",
  "content": "Hello",
  "imgSize": "BIG",
  "logoPath": "Desktop\\312321312asd.jpg"
}
```

- imgFormat：jpg、png、gif
- imgSize：MINI、SMALL、MIDDLE、BIG

#### 2 二维码->文字

```shell
POST ：http://${IP}/decodeImg
```

```json
{
  "file": "Desktop\\QQ图片20220603175226.jpg"
}
```

### 4 TODO

- 接口防刷
- 定时清除图片缓冲区

### 5 关于作者
> 公众号【扯编程的淡】：
>
> ![image-20230430204003260](https://img-blog.csdnimg.cn/56b9c71cee5443048fa4b98ba8d98e82.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBATXJfWWFuTWluZ1hpbg==,size_20,color_FFFFFF,t_70,g_se,x_16)

> 感谢您的支持，可扫码进行赞赏<**微信**>:
>
> <img src="https://img-blog.csdnimg.cn/8233dee0e742434e8e1a1684004a7f4e.png" alt="微信图片_20230430202859" style="zoom: 70%;" />
