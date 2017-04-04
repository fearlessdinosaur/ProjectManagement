//basic skeleton code found online
package ie.dit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.*;


import java.io.IOException;

public class Client {



    String name;
    String pass;
    void post(String user,String password ) throws JSONException {
        name=user;
        pass=password;

        HttpClient post = HttpClientBuilder.create().build();
        HttpPost target = new HttpPost("http://147.252.137.5:8082");
       try
       {
           JSONObject input = new JSONObject();
           input.put("name",name);
           input.put("password",pass);
           input.put("Code",1);

           StringEntity entity = new StringEntity(String.valueOf(input),ContentType.APPLICATION_JSON);
           target.setEntity(entity);
           HttpResponse reply = post.execute(target);
           System.out.println(reply);

       } catch (IOException e)
       {
           e.printStackTrace();
       }

   }
   void get() throws JSONException
   {
       HttpClient get = HttpClientBuilder.create().build();


       HttpGet data = new HttpGet("http://147.252.137.5:8082");
       try {
           HttpResponse reply = get.execute(data);
           System.out.println(reply);
           BufferedReader readIn = new BufferedReader(new InputStreamReader(reply.getEntity().getContent()));
           String[] file = new String[999];
           int i=0;
           String line = "";
           while ((line = readIn.readLine()) != null) {
               file[i]= line;
               i++;
           }
           System.out.println(file[1]);
       }
       catch(Exception e) {

       }
   }

}
