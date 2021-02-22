package com.example.bottomnavmyapplication;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {

    public HttpHandler() {
    }

    public String serviceCall (String reqUrl){
        String reponse = null;

        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            reponse = convertInputtoString(in);
        } catch (MalformedURLException e) {
            System.out.println("erreur 01 : "+e.getMessage());
        } catch (ProtocolException e) {
            System.out.println("erreur 02 : "+e.getMessage());
        } catch (IOException e) {
            reponse = "non";
            System.out.println("erreur 04 : "+e.getMessage());
        }catch (Exception e) {
            System.out.println("erreur 05    : "+e.getMessage());
        }
        return reponse;
    }

    private String convertInputtoString(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
