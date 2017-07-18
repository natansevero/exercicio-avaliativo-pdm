package com.natansevero.android.questao_05;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CONTEXT_INCLUDE_CODE;

public class PapoActivity extends Activity {

    private ListView listView;
    private Button botaoSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papo);

        botaoSend = (Button) findViewById(R.id.button_send);
        listView = (ListView) findViewById(R.id.listView);

        TarefaRequest request = new TarefaRequest();
        request.execute("https://messages-api-nodejs.herokuapp.com/messages");

        botaoSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    private List<String> jsonToObject(String data) {
        List<String> messages = new ArrayList<>();

        try {
            JSONObject jo = new JSONObject(data);
            JSONArray ja;

            ja = jo.getJSONArray("messages");
            for(int i = 0; i < ja.length(); i++) {
                messages.add(ja.getJSONObject(i).getString("message"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return messages;
    }

//    private String objectToJson(Message message) {
//        JSONObject jo = new JSONObject();
//
//        try {
//            jo.put("user", message.getUser());
//            jo.put("message", message.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return jo.toString();
//    }

    // Asynctask que chama o método estático da classe HttpConnection que realizar a requisição
    private class TarefaRequest extends AsyncTask<String, Void, List<String>> {

        @Override
        protected List<String> doInBackground(String... params) {
            // Chamada do método estático pra faz a requisição
            String responseJson = HttpConnection.executeGetRequest(params[0]);

            return jsonToObject(responseJson);
        }

        @Override
        protected void onPostExecute(List<String> messages){
            // Setando valores na view
//            textLogradouro.setText(cepResult.getLogradouro());
//            textBairro.setText(cepResult.getBairro());
//            textMunicipio.setText(cepResult.getMunicipio() + " - " + cepResult.getUf());
            for(String m : messages) {
                System.out.println(m);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    messages
            );

            listView.setAdapter(adapter);
        }
    }
}
