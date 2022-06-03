### 整体架构

![img.png](img.png)

### 注意点

- 拦截器：防刷接口
- Shell脚本：定时清除logo图片缓存

### 进展

![img_1.png](img_1.png)

### 请求样例

```json
{
  "imgFormat": "jpg",
  "content": "Hello",
  "imgSize": "BIG",
  "logoPath": "C:\\Users\\17122\\Desktop\\QQ图片20220603175226.jpg"
}
```

- imgFormat:jpg、png、gif
- imgSize:MINI、SMALL、MIDDLE、BIG
