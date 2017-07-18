package com.natansevero.android.questao_02;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Atributo representa o campo de quantidade de adultos
    private EditText campoAdultos;
    // Atributo repesenta o campo de quantidade de crianças
    private EditText campoCriancas;
    // Atributo representa o botao de calcular
    private Button botaoCalcular;

    // Atributo representa o texto onde será apresentado o calculo de quantidade em kg de bolo
    private TextView textoQuantBolo;
    // Atributo representa o texto onde será apresentado o calculo da quantidade em unidade de doces
    private TextView textoQuantDoce;
    // Atributo representa o texto onde será apresentado o calculo da quantidade em unidade de doces
    private TextView textoQuantSalgado;
    // Atributo representa o texto onde serpa apresentado o calculo de quantidade em litros de refrigerante
    private TextView textoQuantRefri;

    // Constantes com valores da tabela de consulto
    private final double ADULTO_BOLO = 0.6;
    private final double CRIANCA_BOLO = 0.4;
    private final double ADULTO_SALGADO = 6.0;
    private final double CRIANCA_SALGADO = 4.0;
    private final double ADULTO_DOCE = 8.0;
    private final double CRIANCA_DOCE = 6.0;
    private final double ADULTO_REFRI = 0.6;
    private final double CRIANCA_REFRI = 0.5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Capturando views pelo id
        campoAdultos = (EditText) findViewById(R.id.edittext_adultos);
        campoCriancas = (EditText) findViewById(R.id.edittext_criancas);
        botaoCalcular = (Button) findViewById(R.id.botao_calcular);

        textoQuantBolo = (TextView) findViewById(R.id.text_quant_bolo);
        textoQuantDoce = (TextView) findViewById(R.id.text_quant_doce);
        textoQuantSalgado = (TextView) findViewById(R.id.text_quant_salgado);
        textoQuantRefri = (TextView) findViewById(R.id.text_quant_refrigerante);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capturando valores digitados nos campo de texto
                String campo_adulto = campoAdultos.getText().toString();
                String campo_crianca= campoCriancas.getText().toString();

                // Verificando se os campos são vazios
                if(campo_adulto.equals("") || campo_crianca.equals("")) {
                    // Exibindo Toast casos os campos estejam em branco
                    Toast.makeText(getApplication(), "Nenhum campo pode ficar vazio", Toast.LENGTH_LONG).show();
                } else {
                    // Parse dos valores vindos do tipo String para Double
                    double adulto = Double.parseDouble(campo_adulto);
                    double crianca = Double.parseDouble(campo_crianca);

                    // Chamada dos metodos para calculo
                    calcQuantBolo(adulto, crianca);
                    calcQuantDoce(adulto, crianca);
                    calcQuantSalgado(adulto, crianca);
                    calcQuantRefri(adulto, crianca);
                }

            }
        });

    }

    // Método para calcular a quantidade de KG de bolo necessário pra festa
    private void calcQuantBolo(double quantAdulto, double quantCrianca) {
        double resultAdulto = quantAdulto * ADULTO_BOLO;
        double resultCrianca = quantCrianca * CRIANCA_BOLO;
        double finalResult = resultAdulto + resultCrianca;

        textoQuantBolo.setText(""+finalResult);
    }

    // Metodo para calcular a quantidade de doces em unidades para a festa
    private void calcQuantDoce(double quantAdulto, double quantCrianca) {
        double resultAdulto = quantAdulto * ADULTO_DOCE;
        double resultCrianca = quantCrianca * CRIANCA_DOCE;
        double finalResult = resultAdulto + resultCrianca;

        textoQuantDoce.setText(""+finalResult);
    }

    // Método para calcular a quantidade de salgados em unidades para a festa
    private void calcQuantSalgado(double quantAdulto, double quantCrianca) {
        double resultAdulto = quantAdulto * ADULTO_SALGADO;
        double resultCrianca = quantCrianca * CRIANCA_SALGADO;
        double finalResult = resultAdulto + resultCrianca;

        textoQuantSalgado.setText(""+finalResult);
    }

    // Metodo para calcular a quantidade em litros de refrigerante necessário pra festa
    private void calcQuantRefri(double quantAdulto, double quantCrianca) {
        double resultAdulto = quantAdulto * ADULTO_REFRI;
        double resultCrianca = quantCrianca * CRIANCA_REFRI;
        double finalResult = resultAdulto + resultCrianca;

        textoQuantRefri.setText(""+finalResult);
    }
}
