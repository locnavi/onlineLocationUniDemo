# LocNavi-OnlineLocationSDK

LocNavi-OnlineLocationSDK 是将Android sdk封装成uniapp 可以调用的插件

## uniApp调用方法

### 引用本地插件

在nativeplugins文件加下放置LocNavi-OnlineLocationSDK插件，并在manifest.json中引用本地插件

### 代码内引用插件

var LocNaviUniClient = uni.requireNativePlugin("LocNavi-OnlineLocationSDK")

### setBaseUri

```javascript
    LocNaviUniClient.setBaseUri({
      'uri': "http://192.168.0.1:8080"
     });
```

### 登录、登出

```javascript
        //登录
    LocNaviUniClient.setUserInfo({
      'name': "pda",
      "id": "12345"
     });
        //登出
    LocNaviUniClient.setUserInfo();
```

### 设定定位上报Api

```javascript
    LocNaviUniClient.setUploadApi("http://192.168.2.16:3939/tagLocation");
```

### 设定beacon扫描模式

```javascript
    //ibeacon 0、beacon 1
    LocNaviUniClient.setBeaconMode(0);
```

### 开始定位

```javascript
    LocNaviUniClient.start();
```

### 停止定位

```javascript
    LocNaviUniClient.stop();
```

### 配送事件

```javascript
//开始配送
    LocNaviUniClient.track({
      'event': "Start Delivery",
      'properties': {
       "DELIVERY_CODE": "配送单号" // 配送相关字段
      }
     });
                    //结束配送
                        LocNaviUniClient.track({
      'event': "End Delivery",
      'properties': {
       "DELIVERY_CODE": "配送单号" // 配送相关字段
      }
     });
//取消配送
                        LocNaviUniClient.track({
      'event': "Cancel Delivery",
      'properties': {
       "DELIVERY_CODE": "配送单号" // 配送相关字段
      }
     });
```
