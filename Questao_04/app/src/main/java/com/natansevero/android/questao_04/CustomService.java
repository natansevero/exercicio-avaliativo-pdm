package com.natansevero.android.questao_04;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by natan on 16/07/17.
 */
public class CustomService extends IntentService {
    public CustomService(){
        super("CustomService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String urlFile = intent.getStringExtra("urlFile");
        String fileName = intent.getStringExtra("fileName");

        try {
            URL url = new URL(urlFile);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            File sdCardRoot = Environment.getExternalStorageDirectory();
            File file = new File(sdCardRoot, fileName);

            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buffer = new byte[1024];
            int bufferLenght = 0;

            while((bufferLenght = inputStream.read(buffer)) > 0){
                fileOutput.write(buffer, 0, bufferLenght);
            }

            fileOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
