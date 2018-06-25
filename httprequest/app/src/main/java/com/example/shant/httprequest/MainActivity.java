package com.example.shant.httprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.StringBuilder;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL url;
        try {
            TextView outputview = (TextView) findViewById(R.id.textView);

            url = new URL("https://www.google.co.in/");

            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
           /// connection.setRequestProperty();
            connection.setDoOutput(true);

            DataOutputStream dstream = new DataOutputStream(connection.getOutputStream());

           // dstream.writeBytes();

            int responseCode  = connection.getResponseCode();

            String output = "Request URL" + url;

            output+=System.getProperty("line.separator")+ "ResponseCode" + responseCode;

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            StringBuilder responseOutput = new StringBuilder();

            while((line = br.readLine())!=null)
            {
                responseOutput.append(line);

            }
            br.close();
            output+=System.getProperty("line.separator")+ responseOutput.toString();

            outputview.setText(output);




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
