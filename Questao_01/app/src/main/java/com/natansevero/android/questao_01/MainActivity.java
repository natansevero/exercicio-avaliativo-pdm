package com.natansevero.android.questao_01;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Atributo que representa o campo de texto onde o usuário digita o nome do time
    private EditText campoNomeTime;
    // Atributo que representa o botão de adicionar um time na LISTVIEW
    private Button botaoAdd;
    // Atributos que representa a LISTVIEW
    private ListView listaTimes;
    // ArrayList contento os dados do ListView
    private ArrayList<String> times = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Capturando a view de campo de texto pelo ID
        campoNomeTime = (EditText) findViewById(R.id.text_team_name);
        // Capturando a view botao adicionar pelo ID
        botaoAdd = (Button) findViewById(R.id.botao_add);

        // Campturando a view ListView pelo ID
        listaTimes = (ListView) findViewById(R.id.list_view);
        // Adapater para preparar os dados do ArrayList para serem colocado no ListView
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                times
        );
        // Setando o adapter no LIstView
        listaTimes.setAdapter(adapter);

        // Acão para quando o usuário adicionar o=um novo time, o dado seja adicionado na ListView em tempo real
        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = campoNomeTime.getText().toString();
                if(time.length() > 0) {
                    campoNomeTime.setText("");
                    campoNomeTime.findFocus();
                    times.add(time);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Digite o nome de um time!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Ação quando o usuário tocar em um item da listView, ir para outra Activity passando o nome do time
        listaTimes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String timeClicado = listaTimes.getItemAtPosition(position).toString();

                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("timeSelecionado", timeClicado);

                startActivity(intent);
            }
        });


    }
}
