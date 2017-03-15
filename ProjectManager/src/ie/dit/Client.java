package ie.dit;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;

import java.io.IOException;

import java.util.*;
public class Client {
    static List<NameValuePair> NamePairs = new ArrayList<>();
    String name="jim";
    String pass = "pass";
    void post()
   {


       HttpClient client = HttpClientBuilder.create().build();
       NamePairs.add(new BasicNameValuePair("name",name));
       NamePairs.add(new BasicNameValuePair("Password",pass));

       HttpPost data = new HttpPost("http://192.168.1.16:1440");
       try
       {
           data.setEntity(new UrlEncodedFormEntity(NamePairs));
           HttpResponse reply = client.execute(data);
           System.out.println("success");

       } catch (IOException e)
       {
           e.printStackTrace();
       }

   }

}
