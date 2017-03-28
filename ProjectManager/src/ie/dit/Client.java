package ie.dit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;


import java.io.IOException;

import java.util.*;
public class Client {



    String name="jim";
    String pass = "pass";
    void post() throws JSONException {


       HttpClient client = HttpClientBuilder.create().build();


       HttpPost data = new HttpPost("http://147.252.136.126:8081");
       try
       {
           JSONObject input = new JSONObject();
           input.put("name",name);
           input.put("password",pass);
           input.put("Code",1);

           StringEntity entity = new StringEntity(String.valueOf(input),ContentType.APPLICATION_JSON);
           data.setEntity(entity);
           HttpResponse reply = client.execute(data);
           System.out.println(reply);

       } catch (IOException e)
       {
           e.printStackTrace();
       }

   }

}
