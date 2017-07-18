package com.natansevero.android.questao_03;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // Atributo do campo de texto da view
    private EditText campoCep;
    // Atributo do botao da view
    private Button botao;
    // Atributo TextView pra apresentar o resultado do logradouro
    private TextView textLogradouro;
    // Atributo TextView pra apresentar o resultado do Bairro
    private TextView textBairro;
    // Atributo TextView pra apresentar o resultado do Mucinípio - UF
    private TextView textMunicipio;
    // Atributo ProgressDialog da modal de carregamento
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Capturando o contexto das View pelo ID
        campoCep = (EditText) findViewById(R.id.edit_cep);
        textLogradouro = (TextView) findViewById(R.id.text_lougradouro);
        textBairro = (TextView) findViewById(R.id.text_bairro);
        textMunicipio = (TextView) findViewById(R.id.text_municipio);
        botao = (Button) findViewById(R.id.botao);

        // Ação de click no botão pra realizar chamada dos métodos abaixo
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Captura do conteudo do EditText da view que contem o Cep que o usuário deseja consultar
                String cep = campoCep.getText().toString();
                String url = "https://viacep.com.br/ws/"+ cep +"/json/";

                // Chamada do método que instancia a AsyncTask e a executa passando a url do web service
                consulta(url);
            }
        });

    }

    // Método que instancia a AsyncTask e a executa
    public void consulta(String url) {
        TarefaRequest request = new TarefaRequest();
        request.execute(url);
    }

    // Método para fazer o parse da String JSON para um objeto CEP
    private CEP jsonToObject(String data) {
        CEP cep = new CEP();

        try {
            JSONObject jo = new JSONObject(data);

            cep.setLogradouro(jo.getString("logradouro"));
            cep.setBairro(jo.getString("bairro"));
            cep.setMunicipio(jo.getString("localidade"));
            cep.setUf(jo.getString("uf"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cep;
    }

    // Asynctask que chama o método estático da classe HttpConnection que realizar a requisição
    private class TarefaRequest extends AsyncTask<String, Void, CEP> {
        @Override
        protected void onPreExecute(){
            // Chamada do ProgressDialog
            load = ProgressDialog.show(MainActivity.this, "Por favor Aguarde ...", "Realizando Consulta ...");
        }

        @Override
        protected CEP doInBackground(String... params) {
            // Chamada do método estático pra faz a requisiçaõ
            String responseJson = HttpConnection.executeGetRequest(params[0]);

            return jsonToObject(responseJson);
        }

        @Override
        protected void onPostExecute(CEP cepResult){
            // Setando valores na view
            textLogradouro.setText(cepResult.getLogradouro());
            textBairro.setText(cepResult.getBairro());
            textMunicipio.setText(cepResult.getMunicipio() + " - " + cepResult.getUf());

            load.dismiss();
        }
    }
}
