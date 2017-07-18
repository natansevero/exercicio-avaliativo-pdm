package com.natansevero.android.questao_03;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by natan on 15/07/17.
 */
// Classe para que auxilia na conexão
public class HttpConnection {
    // Meétodo estático que realizar a requisão pro web service
    public static String executeGetRequest(String url) {
        String anwser = "";
        try {
            URL u = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) u.openConnection();

            InputStream in = urlConnection.getInputStream();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while((inputStr = streamReader.readLine()) != null){
                responseStrBuilder.append(inputStr);
            }

            JSONObject json = new JSONObject(responseStrBuilder.toString());

            anwser = json.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return anwser;
    }

}
