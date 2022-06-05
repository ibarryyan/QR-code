### 整体架构

![img.png](img.png)

### 注意点

- 拦截器：防刷接口
- Shell脚本：定时清除logo图片缓存

### 进展

![img_1.png](img_1.png)

### 请求样例

#### 1 文字->二维码

上传Logo

```shell
http://${IP}/uploadLogo
```
```json
{
  "file": "C:\\Users\\17122\\Desktop\\QQ图片20220603175226.jpg"
}
```

生成二维码：

```shell
http://${IP}/encodeImg
```

```json
{
  "imgFormat": "jpg",
  "content": "Hello",
  "imgSize": "BIG",
  "logoPath": "C:\\Users\\17122\\Desktop\\312321312asd.jpg"
}
```

- imgFormat:jpg、png、gif
- imgSize:MINI、SMALL、MIDDLE、BIG

#### 2 二维码->文字

```shell
http://${IP}/decodeImg
```
```json
{
  "file": "C:\\Users\\17122\\Desktop\\QQ图片20220603175226.jpg"
}
```