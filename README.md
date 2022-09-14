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
公众号：

<img src="https://ibarryyan.oss-cn-hangzhou.aliyuncs.com/httpweixin.q.png" alt="htt" style="zoom:50%;" />

> 赞赏，请作者喝杯咖啡

<img src="https://ibarryyan.oss-cn-hangzhou.aliyuncs.com/wxpf2f0__bF3.png" alt="htt" style="zoom: 50%;" />
