package com.example.googlemap;

import android.content.Context;
import android.os.AsyncTask;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
/*
public class Server {
    int Result;
    int Company_Register;
    byte[] returnByte;
    int toggle=0;
    
    CompanyDTO CompanyDetailsDTO;
    List<byte[]> ReturnByteArray;
    private String SERVER_URL = "https://kcf-vdpyu.run.goorm.io/";
    public List<CompanyDTO> SearchByFilter(String name, boolean Filter1,boolean Filter2, boolean Filter3,String Region, String kinds){
        RequestParams params = new RequestParams();
        params.put("name",name);
        params.put("Filter1",String.valueOf(Filter1));
        params.put("Filter2",String.valueOf(Filter2));
        params.put("Filter3",String.valueOf(Filter3));
        params.put("Region",Region);
        params.put("Kinds",kinds);

        AsyncHttpClient httpClient = new AsyncHttpClient();
        List<CompanyDTO> companyDTOs = new ArrayList<>();
        httpClient.get(SERVER_URL + "company/ViewLists/NameWithFilterAndRegionskinds", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONParser parser = new JSONParser();
                try {
                    JSONArray array = (JSONArray) parser.parse(new String(responseBody,"UTF-8"));
                    for(int i=0; i< array.length();i++){
                        JSONObject obj = (JSONObject) array.get(i);
                        CompanyDTO companyDTO = new CompanyDTO();
                        companyDTO.setId((Long) obj.get("id"));
                        companyDTO.setPositionX((Float) obj.get("positionX"));
                        companyDTO.setPositionY((Float) obj.get("positionY"));
                        companyDTO.setName((String) obj.get("name"));
                        companyDTO.setInfo((String) obj.get("info"));
                        companyDTO.setRegion((String) obj.get("region"));
                        companyDTOs.add(companyDTO);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


        return companyDTOs;
    }
    public void ViewCompanyDetails(long id, Context context){
    String url = SERVER_URL+"company/Details/info/"+id;
    AsyncHttpClient client = new AsyncHttpClient() ;
    MyApplication var = (MyApplication) context.getApplicationContext();
   client.get(url,  new AsyncHttpResponseHandler() {
       @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    JSONParser parser = new JSONParser();
        JSONObject obj = null;
           try {
               obj = (JSONObject) parser.parse(new String(responseBody,"UTF-8"));
           } catch (ParseException e) {
               e.printStackTrace();
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
             CompanyDTO companyDTO= new CompanyDTO();
                companyDTO.setId((Long) obj.get("id"));
                companyDTO.setPositionX(Float.parseFloat(String.valueOf(obj.get("positionX"))));
                companyDTO.setPositionY(Float.parseFloat(String.valueOf(obj.get("positionY"))));
                companyDTO.setName((String) obj.get("name"));
                companyDTO.setInfo((String) obj.get("info"));
                companyDTO.setRegion((String) obj.get("region"));
                 System.out.println(String.valueOf(obj.get("positionX")));
                System.out.println("값 : "+Float.parseFloat(String.valueOf(obj.get("positionX"))));
                Store1 store1 = new Store1();
                //store1.SetMessage("aehsrhrr");
                var.setCallback_Detail_View(companyDTO);
                var.setToggle(true);
                }
                             @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("오류!");
            }
            });


    }











    public int Login(String id, String pw){

        RequestParams params = new RequestParams();
        params.put("Id",id);
        params.put("Pw", pw);
        Result=0;
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(SERVER_URL + "User/Login/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                     Result = Integer.parseInt(new String(responseBody,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return Result;
    }

    public int Company_Register(CompanyDTO companyDTO, File[] file) throws FileNotFoundException {
        RequestParams params = new RequestParams();
        params.put("owner",companyDTO.getOwner());
        params.put("ownername",companyDTO.getOwnername());
        params.put("name",companyDTO.getName());
        params.put("region",companyDTO.getRegion());
        params.put("info",companyDTO.getInfo());
        params.put("positionX",companyDTO.getPositionX());
        params.put("positionY",companyDTO.getPositionY());
        params.put("category",companyDTO.getCategory());
        params.put("filter1",companyDTO.getFilter1());
        params.put("filter2",companyDTO.getFilter2());
        params.put("filter3",companyDTO.getFilter3());
        params.put("images",file);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(SERVER_URL + "company/Register/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Company_Register = Integer.parseInt(new String(responseBody,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return Company_Register;
    }
    public List<byte[]> GetImageCompany(long id){
        AsyncHttpClient client = new AsyncHttpClient();
        ReturnByteArray.clear();
        client.get(SERVER_URL + "company/Details/image" + id, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    List<String> imgsrc;

                    imgsrc = (List<String>) new JSONArray(new String(responseBody,"UTF-8")); //이렇게 해도 되나...?
                    for(String src : imgsrc){
                       ReturnByteArray.add(GetImage(src));
                    }
                } catch (JSONException | UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return ReturnByteArray;
    }
    public byte[] GetImage(String Src){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("url",Src);
        returnByte=null;
        client.post(SERVER_URL + "Image/download", params, new BinaryHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
                returnByte = binaryData;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {

            }
        });
        return returnByte;
    }

    public int NewCustom(CustomDTO customDTO, File[] files) throws FileNotFoundException {
        RequestParams params = new RequestParams();
        params.put("company",customDTO.getCompanyfk());
        params.put("name",customDTO.getName());
        params.put("kinds",customDTO.getKinds());
        params.put("userfk",customDTO.getUserfk());
        params.put("orderfk",customDTO.getOrderfk());
        params.put("customImage",customDTO.getImage());
        params.put("images",files);
        Result =0;
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(SERVER_URL + "Custom/New/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Result = Integer.parseInt(new String(responseBody,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return Result;
    }

    public CustomDTO CustomViewId(long idx){
        AsyncHttpClient client = new AsyncHttpClient();
        CustomDTO customDTO = new CustomDTO();
        client.get(SERVER_URL + "Custom/View/id/" + idx, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONParser parser = new JSONParser();
                try {
                    JSONObject obj = (JSONObject) parser.parse(new String(responseBody,"UTF-8"));

                    customDTO.setId(Long.parseLong(obj.get("id").toString()));
                    customDTO.setImage(obj.get("image").toString());
                    customDTO.setKinds(obj.get("kinds").toString());
                    customDTO.setCompanyfk(Long.parseLong(obj.get("companyfk").toString()));
                    customDTO.setUserfk(obj.get("userfk").toString());
                    customDTO.setOrderfk(Long.parseLong(obj.get("orderfk").toString()));


                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return customDTO;
    }
    public List<byte[]> GetImageCustom(String imageid){
        RequestParams params = new RequestParams();
        params.put("Customidx",imageid);
        ReturnByteArray.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(SERVER_URL + "Custom/View/Image/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                try {
                    List<String> imgsrc;
                    imgsrc = (List<String>) new JSONArray(new String(responseBody,"UTF-8")); //이렇게 해도 되나...?
                    for(String src : imgsrc){
                        ReturnByteArray.add(GetImage(src));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return ReturnByteArray;
    }
    public CustomDTO CustomViewOrderId(long idx){
        AsyncHttpClient client = new AsyncHttpClient();
        CustomDTO customDTO = new CustomDTO();
        client.get(SERVER_URL + "Custom/View/Order/" + idx, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONParser parser = new JSONParser();
                try {
                    JSONObject obj = (JSONObject) parser.parse(new String(responseBody,"UTF-8"));

                    customDTO.setId(Long.parseLong(obj.get("id").toString()));
                    customDTO.setImage(obj.get("image").toString());
                    customDTO.setKinds(obj.get("kinds").toString());
                    customDTO.setCompanyfk(Long.parseLong(obj.get("companyfk").toString()));
                    customDTO.setUserfk(obj.get("userfk").toString());
                    customDTO.setOrderfk(Long.parseLong(obj.get("orderfk").toString()));


                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return customDTO;
    }
    public int RegisterOrder(OrderDTO orderDTO){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("company",orderDTO.getCompanyfk());
        params.put("cost",orderDTO.getCost());
        params.put("count",orderDTO.getCount());
        params.put("custom",orderDTO.getCustomfk());
        params.put("userfk",orderDTO.getUserfk());
        Result =0;
        client.post(SERVER_URL + "Order/new/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Result = Integer.parseInt(new String(responseBody,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return Result;
    }

    public int UserRegister(UserDTO userDTO){
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        params.put("id",userDTO.getId());
        params.put("username", userDTO.getUsername());
        params.put("mobile",userDTO.getMobile());
        params.put("email",userDTO.getEmail());
        params.put("isboss",userDTO.isIsboss());
        params.put("password",userDTO.getPassword());
        Result =0;
        client.post(SERVER_URL + "User/Register/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Result = Integer.parseInt(new String(responseBody,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return Result;
    }


}
*/