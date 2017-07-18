package com.natansevero.android.questao_05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoPessoa1;
    private Button botaoPessoa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoPessoa1 = (Button) findViewById(R.id.button_pessoa1);

        botaoPessoa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PapoActivity.class);
                startActivity(intent);
            }
        });
    }
}
