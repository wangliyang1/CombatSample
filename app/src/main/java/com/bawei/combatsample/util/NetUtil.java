package com.bawei.combatsample.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtil {
    private static NetUtil netUtil = new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }
    @SuppressLint("StaticFieldLeak")
    public void getJson(final String dizhi, final Callback callback){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {

                if (TextUtils.isEmpty(s)){
                    callback.onError(new Exception("请求失败"));
                }else {
                    callback.OnGetJson(s);}
            }

            @Override
            protected String doInBackground(Void... voids) {
                InputStream inputStream = null;
                String s = "";
                try {
                    URL url = new URL(dizhi);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setReadTimeout(8000);
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.connect();
                    if (urlConnection.getResponseCode()==200){
                        inputStream = urlConnection.getInputStream();
                        s = io2String(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return s;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }
    public interface Callback{
        void OnGetJson(String s);
        void onError(Throwable throwable);
    }
    public String io2String(InputStream inputStream) throws IOException {
        int len=-1;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String s = new String(bytes1);
        return s;
    }
    @SuppressLint("StaticFieldLeak")
    public void getPhono(final String imageurl, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream = null;
                Bitmap s = null;
                try {
                    URL url = new URL(imageurl);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setReadTimeout(8000);
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.connect();
                    if (urlConnection.getResponseCode()==200){
                        inputStream = urlConnection.getInputStream();
                        s = io2Bitmap(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return s;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }
    public Bitmap io2Bitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }
}
