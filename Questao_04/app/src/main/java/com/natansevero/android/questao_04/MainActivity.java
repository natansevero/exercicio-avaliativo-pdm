package com.natansevero.android.questao_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLink;
    private Button buttonDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLink = (EditText) findViewById(R.id.edit_text_link);
        buttonDownload = (Button) findViewById(R.id.button_download);

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile();
            }
        });
    }

    private void downloadFile() {
//        String urlFile = editTextLink.getText().toString();
        Intent intent = new Intent(this, CustomService.class);
        intent.putExtra("urlFile", "https://img.ibxk.com.br///2015/05/14/14193342470791-t1200x480.jpg");
        intent.putExtra("fileName", "index.html");
        startService(intent);
        System.out.println("Botão!");
    }
}
