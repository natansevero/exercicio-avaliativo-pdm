package com.natansevero.android.questao_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    // Atributo que representa a textView que será apresentado o time selecionado na listView da Activity Anterior
    private TextView textoTimesSelecioando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        // Capturando o dado que vem na Activity anterior
        String timeSelecionado = getIntent().getExtras().getString("timeSelecionado");

        // Capturando a view pelo id
        textoTimesSelecioando = (TextView) findViewById(R.id.text_time_selecionado);

        // Setando o dado que veio pela navegação na View
        textoTimesSelecioando.setText(timeSelecionado);

    }
}
