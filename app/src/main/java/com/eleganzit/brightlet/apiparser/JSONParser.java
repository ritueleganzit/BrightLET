package com.eleganzit.brightlet.apiparser;

import android.support.annotation.NonNull;
import android.util.Log;

import com.eleganzit.brightlet.utils.Constants;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by codesture18 on 7/4/2017.
 */

public class JSONParser {

    private static Response response;

    public static JSONObject doGet(HashMap<String,String> param, String url)
    {

        JSONObject result = null;
        String response;
        Set keys = param.keySet();

        int count = 0;
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            count++;
            String key = (String) i.next();
            String value = (String) param.get(key);
            if (count == param.size()) {
                Log.e("Key", key + "");
                Log.e("Value", value + "");
                url += key + "=" + URLEncoder.encode(value);

            } else {
                Log.e("Key", key + "");
                Log.e("Value", value + "");

                url += key + "=" + URLEncoder.encode(value) + "&";
            }

        }
        Log.e("CALL_URL", url);
        OkHttpClient client = new OkHttpClient();

        Request request;
        Response responseClient = null;

        try {
            request = new Request.Builder()
                    .url(url)
                    .build();
            responseClient = client.newCall(request).execute();
            response = responseClient.body().string();

            result = new JSONObject(response);
            Log.e("response", response + "==============");


        } catch (IllegalArgumentException e) {
            JSONObject jsonObject = new JSONObject();

            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {



        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();

            return jsonObject;
        }

        return result;
    }
    public static JSONObject doPost(HashMap<String, String> data, String url) {


        Log.e("URL", url);
        try {
            RequestBody requestBody;
            MultipartBuilder mBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);

            if (data != null) {
                for (String key : data.keySet()) {
                    String value = data.get(key);
                    Log.e("Key Values", key + "=" + value);
                    mBuilder.addFormDataPart(key, value);
                }
            } else {
                mBuilder.addFormDataPart("temp", "temp");
            }

            requestBody = mBuilder.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            url = "";
            Log.e("User", responseBody);
            return new JSONObject(responseBody);

        } catch (UnknownHostException | UnsupportedEncodingException e) {

            /*JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("status", "false");
                jsonObject.put("message", e.getLocalizedMessage());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }*/
            Log.e("", "Error: " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
           /* JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("status", "false");
                jsonObject.put("message", e.getLocalizedMessage());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }*/
            Log.e("", "Other Error: " + e.getLocalizedMessage());
        }
        return null;
    }
    public static JSONObject getDataFromWeb() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(Constants.URL)
                    .build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (@NonNull IOException | JSONException e) {
        }
        return null;
    }


    public static JSONObject doPostRequestWithFile(HashMap<String, String> data,
                                                   String url,
                                                   ArrayList<String> imageList,
                                                   String fileParamName) {



        try {
            final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

            Log.e("Method", "=======");
            RequestBody requestBody;
            MultipartBuilder mBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);

            for (String key : data.keySet()) {
                String value = data.get(key);
                Log.e("Key Values", key + "-----------------" + value);

                mBuilder.addFormDataPart(key, value);

            }
            for (int i = 0; i < imageList.size(); i++) {
                File f = new File(imageList.get(i));

                Log.e("File Name 322", f.getName() + "===========");
                if (f.exists()) {
                    Log.e("File Exits", "===================");
                    mBuilder.addFormDataPart(fileParamName, f.getName(), RequestBody.create(MEDIA_TYPE_PNG, f));
                }
            }
            requestBody = mBuilder.build();


            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();


            String result = response.body().string();

            Log.e("Response", result + "");
            return new JSONObject(result);

        } catch (UnknownHostException | UnsupportedEncodingException e) {
            Log.e(Constants.TAG, "Error: " + e.getLocalizedMessage());
            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("status", "false");
                jsonObject.put("message", e.getLocalizedMessage());
                return jsonObject;

            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            Log.e(Constants.TAG, "Other Error: " + e.getMessage());
            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("status", "false");
                jsonObject.put("message", e.getLocalizedMessage());
                return jsonObject;
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
