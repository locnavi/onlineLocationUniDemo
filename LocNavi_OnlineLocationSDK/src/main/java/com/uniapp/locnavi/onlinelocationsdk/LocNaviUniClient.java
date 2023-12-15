package com.uniapp.locnavi.onlinelocationsdk;

import com.alibaba.fastjson.JSONObject;

import android.content.Context;
import android.util.Log;

import com.locnavi.location.online.LocNaviClient;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniJSCallback;
import io.dcloud.feature.uniapp.common.UniModule;

public class LocNaviUniClient extends UniModule {
    String TAG = "LocNaviUniClient";

    //run ui thread
    @UniJSMethod(uiThread = true)
    public void setBaseUri(JSONObject data, UniJSCallback callback) {
        Log.e(TAG, "testAsyncFunc--"+ data.toString());
        try {
            Context context = this.mUniSDKInstance.getContext();
            LocNaviClient client = LocNaviClient.getInstanceForApplication(context.getApplicationContext());
            if (data != null) {
                String uri = data.getString("uri");
                client.setBaseUri(uri);
            }
        }catch (Exception e) {
            Log.e(TAG, e.getMessage());
            if(callback != null) {
                callback.invoke(e.getMessage());
                //callback.invokeAndKeepAlive(data);
            }
        }
        if(callback != null) {
            callback.invoke("success");
            //callback.invokeAndKeepAlive(data);
        }
    }
}
