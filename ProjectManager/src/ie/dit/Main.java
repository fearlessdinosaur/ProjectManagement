package ie.dit;

/**
 * Created by David on 06/03/2017.
 */import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;

public class Main {
    private static HttpClient client = HttpClientBuilder.create().build();
    public static void main(String args[]) {

        HttpPost httppost = new HttpPost("http://192.168.1.16:1440");
        try
        {
            client.execute(httppost);
            System.out.println("success");

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
