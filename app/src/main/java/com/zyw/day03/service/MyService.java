package com.zyw.day03.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.zyw.day03.bean.MsgEvent;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyService extends Service {

    public class MyBinder extends Binder {

        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void downLoad(final String path, String url) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        InputStream inputStream = response.body().byteStream();
                        long contentLength = response.body().contentLength();

                        initDownLoad(inputStream, contentLength, path);
                    }
                });
    }

    private void initDownLoad(InputStream inputStream, long contentLength, String path) {

        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file);

            int length = 0;
            byte[] bytes = new byte[1024 * 2];
            int progress = 0;

            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
                progress += length;

                EventBus.getDefault().post(new MsgEvent(progress, contentLength, 1));
            }

            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String TAG = "MyService";
}
