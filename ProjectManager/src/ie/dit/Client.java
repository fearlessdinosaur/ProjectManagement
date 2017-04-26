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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Client {


    String name;
    String pass;


    void post(JSONObject user) throws JSONException {


        HttpClient post = HttpClientBuilder.create().build();
        HttpPost target = new HttpPost("http://147.252.137.57:8082");
        try {

            StringEntity entity = new StringEntity(String.valueOf(user), ContentType.APPLICATION_JSON);
            target.setEntity(entity);
            HttpResponse reply = post.execute(target);
            System.out.println(reply);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void postUser(String user, String password) throws JSONException
    {
        name = user;
        pass = password;
        try {
            JSONObject input = new JSONObject();
            input.put("name", name);
            input.put("password", pass);
            input.put("Code", 1);
            post(input);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    void postTeam(String team) throws JSONException
    {
        String Tname = team;
        try {
            JSONObject input = new JSONObject();
            input.put("name", Tname);
            input.put("Code", 2);
            post(input);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    String find(String url) throws JSONException, UnsupportedEncodingException {

        HttpClient get = HttpClientBuilder.create().build();
        String[] file = new String[999];
        HttpGet data = new HttpGet(url);
        try {
            HttpResponse reply = get.execute(data);
            System.out.println(reply);
            BufferedReader readIn = new BufferedReader(new InputStreamReader(reply.getEntity().getContent()));
            int i = 0;
            String read = "";
            while ((read = readIn.readLine()) != null) {
                file[i] = read;
                i++;
            }
            System.out.println(file[0]);

        } catch (Exception e) {

        } finally {

            return file[0];
        }
    }

    String getUser(String name, String pass) throws JSONException, UnsupportedEncodingException {
        String info="";
        int code = 100;
        String url = "http://147.252.137.57:8082?name=" + name + "&pass=" + pass + "&code=" + code;
        try {
            info = find(url);
            System.out.println(info);
        }
        catch (Exception e) {

        }
        finally {

            return info;
        }
    }

    String getTeam(String TeamName) throws JSONException, UnsupportedEncodingException {
        String info;
        int code = 101;
        String url = "http://147.252.137.57:8082?Teamname=" + TeamName+ "&code=" + code;
        info=find(url);
        return info;
    }

}

