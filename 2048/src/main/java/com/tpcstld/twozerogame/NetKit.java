package com.tpcstld.twozerogame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetKit {
    private static final NetKit ourInstance = new NetKit();

    public static NetKit getInstance() {
        return ourInstance;
    }

    private NetKit() {
    }


    public static Bitmap getImage(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream is = conn.getInputStream();
        return BitmapFactory.decodeStream(is);
    }
}
