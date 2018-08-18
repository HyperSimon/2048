package com.tpcstld.twozerogame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetKit {
    private static final NetKit ourInstance = new NetKit();

    public static NetKit getInstance() {
        return ourInstance;
    }

    private NetKit() {
    }

    public static void getImage(String path, final BitMapCallBack callBack) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request r = new Request.Builder().url(path).build();
        Call call = client.newCall(r);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e){
                callBack.getBitMap(null,e );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = response.body().byteStream();
                callBack.getBitMap(BitmapFactory.decodeStream(is), null);
            }
        });
    }
}
