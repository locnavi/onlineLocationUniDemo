# LocNavi-OnlineLocationSDK

LocNavi-OnlineLocationSDK 是将Android sdk封装成uniapp 可以调用的插件

## uniApp调用方法

### 引用本地插件

在nativeplugins文件加下放置LocNavi-OnlineLocationSDK插件，并在manifest.json中引用本地插件

### 代码内引用插件

var LocNaviUniClient = uni.requireNativePlugin("LocNavi-OnlineLocationSDK")

### 申请权限

```javascript
    LocNaviUniClient.checkAvailability((available) => {
     if (!available) {
      //弹框提醒蓝牙设备不可用
     } else {
      plus.android.requestPermissions(['Manifest.permission.BLUETOOTH_SCAN', 'android.permission.ACCESS_FINE_LOCATION', 'android.permission.ACCESS_COARSE_LOCATION', 'android.permission.ACCESS_BACKGROUND_LOCATION'], function(e){
       if(e.deniedAlways.length>0){ //权限被永久拒绝
        // 弹出提示框解释为何需要定位权限，引导用户打开设置页面开启
        console.log('Always Denied!!! '+e.deniedAlways.toString());
       }
       if(e.deniedPresent.length>0){ //权限被临时拒绝
        // 弹出提示框解释为何需要定位权限，可再次调用plus.android.requestPermissions申请权限
        console.log('Present Denied!!! '+e.deniedPresent.toString());
       }
       if(e.granted.length>0){ //权限被允许
           //调用依赖获取定位权限的代码
        console.log('Granted!!! '+e.granted.toString());
       }
      }, function(e){
          console.log('Request Permissions error:'+JSON.stringify(e));
      });
     }
    });
```

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
