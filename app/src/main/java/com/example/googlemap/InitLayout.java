package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class InitLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_layout);
        ServerConnection();

    }
    public void ServerConnection(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://kcf-vdpyu.run.goorm.io/company/ViewLists/AllCompanies", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONParser parser = new JSONParser();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                try {

                    JSONArray ary = (JSONArray) parser.parse(new String(responseBody,"UTF-8"));
                    for(int i=0;i<ary.size();i++){
                        JSONObject obj = (JSONObject) ary.get(i);
                        CompanyDTO cpdto = new CompanyDTO();
                        cpdto.setPositionX(Float.parseFloat(obj.get("positionX").toString()));
                        cpdto.setPositionY(Float.parseFloat(obj.get("positionY").toString()));
                        cpdto.setName(obj.get("name").toString());
                        cpdto.setInfo(obj.get("info").toString());
                        cpdto.setCategory(obj.get("category").toString());
                        intent.putExtra(i+"X",cpdto.getPositionX());
                        intent.putExtra(i+"Y",cpdto.getPositionY());
                        intent.putExtra(i+"cp_name",cpdto.getName());
                        intent.putExtra("size",ary.size());
                        intent.putExtra(i+"kinds",cpdto.getCategory());
                        intent.putExtra(i+"info",cpdto.getInfo());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}