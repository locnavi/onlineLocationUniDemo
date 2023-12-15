package com.uniapp.locnavi.onlinelocationsdk;

import com.alibaba.fastjson.JSONObject;

import android.content.Context;
import android.util.Log;

import com.locnavi.location.online.LocNaviClient;

import java.util.Map;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniJSCallback;
import io.dcloud.feature.uniapp.common.UniModule;

public class LocNaviUniClient extends UniModule {
    String TAG = "LocNaviUniClient";

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void checkAvailability(UniJSCallback callback) {
        Log.d(TAG, "checkAvailability--");
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        if(callback != null) {
            callback.invoke(client.checkAvailability());
        }
    }

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void setBaseUri(JSONObject data, UniJSCallback callback) {
        Log.d(TAG, "setBaseUri--"+ data.toString());
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        if (data != null) {
            String uri = data.getString("uri");
            client.setBaseUri(uri);
        }
        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void setUserInfo(JSONObject data, UniJSCallback callback) {
        Log.d(TAG, "setUserInfo--"+ data.toString());
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        if (data != null) {
            String name = data.getString("name");
            String id = data.getString("id");
            client.setUserInfo(name, id);
        } else {
            client.setUserInfo(null, null);
        }
        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void setUploadApi(String url, UniJSCallback callback) {
        Log.d(TAG, "setUploadApi--"+ url);
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        client.setUploadApi(url);

        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void setBeaconMode(int mode, UniJSCallback callback) {
        Log.d(TAG, "setBeaconMode--"+ mode);
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        client.setBeaconMode(mode);

        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void start(String mode, UniJSCallback callback) {
        Log.e(TAG, "start");
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        client.start(mode);

        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void stop(String mode, UniJSCallback callback) {
        Log.e(TAG, "stop");
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        client.stop(mode);

        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }

    //run ui thread
    @UniJSMethod(uiThread = false)
    public void track(JSONObject params, UniJSCallback callback) {
        Log.e(TAG, "track");
        Context context = this.mUniSDKInstance.getContext();
        LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
        String event = params.getString("event");
        Map<String, String> properties = (Map<String, String>) params.get("properties");
        client.track(event, properties);

        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }
}
