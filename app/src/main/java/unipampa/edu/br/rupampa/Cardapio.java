package unipampa.edu.br.rupampa;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import unipampa.edu.br.rupampa.dao.DAORefeicao;
import unipampa.edu.br.rupampa.model.Refeicao;
import unipampa.edu.br.rupampa.view.CompararDatas;
import unipampa.edu.br.rupampa.view.ListViewAdapter;

public class Cardapio extends AppCompatActivity implements Serializable {
    private static final String TAG_PRATOPRINCIPAL = "pratoprincipal";
    private static final String TAG_SOBREMESA = "sobremesa";
    private static final String TAG_ACOMPANHAMENTOS = "acompanhamento";
    private static final String TAG_SUCO = "suco";
    private static final String TAG_SALADAS = "salada";
    private static final String TAG_ID = "id";
    private static final String TAG_NOMEREFEICAO = "nomerefeicao";
    private static final String TAG_GUARNICAO = "guarnicao";
    private static final String TAG_DATA = "data";
    private static final String TAG_OPCAOVEG = "opcaoveg";
    private static final String JSON_URL = "http://ggirardon.com/ru/ws/retornaRefeicao.php";

    JSONArray refeicoes = null;
    DAORefeicao dao;
    ArrayList<Refeicao> refeicoesList;
    ArrayList<Refeicao> refeicoesListLocal;
    ListView list;

    String myJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
        dao = new DAORefeicao(this);

        list = (ListView) findViewById(R.id.listView);
        refeicoesList = new ArrayList<Refeicao>();

        if(verificaConexao()) {
            getJSON(JSON_URL);

        }else{
            Toast.makeText(Cardapio.this, "Sem internet! Reinicie o aplicativo após conectar a internet.", Toast.LENGTH_SHORT).show();

        }
    }

    protected void showList() {
        try {
            JSONArray jsonObj = new JSONArray(myJSON);
            refeicoes = jsonObj;

            for (int i = 0; i < refeicoes.length(); i++) {

                Refeicao refeicao = new Refeicao();
                JSONObject c = refeicoes.getJSONObject(i);
                String pratoPrincipal = c.getString(TAG_PRATOPRINCIPAL);
                String sobremesa = c.getString(TAG_SOBREMESA);
                String suco = c.getString(TAG_SUCO);
                Long id = Long.valueOf(c.getString(TAG_ID));
                String nomeRefeicao = c.getString(TAG_NOMEREFEICAO);
                String acompanhamentos = c.getString(TAG_ACOMPANHAMENTOS);
                String guarnicao = c.getString(TAG_GUARNICAO);
                String saladas = c.getString(TAG_SALADAS);
                String data = c.getString(TAG_DATA);
                String opcaoVeg = c.getString(TAG_OPCAOVEG);

                refeicao.setPratoPrincipal(pratoPrincipal);
                refeicao.setSobremesa(sobremesa);
                refeicao.setSuco(suco);
                refeicao.setId(id);
                refeicao.setNomeRefeicao(nomeRefeicao);
                refeicao.setAcompanhamentos(acompanhamentos);
                refeicao.setGuarnicao(guarnicao);
                refeicao.setSaladas(saladas);
                refeicao.setData(data);
                refeicao.setOpcaoVeg(opcaoVeg);


                CompararDatas compararDatas = new CompararDatas() {
                    @Override
                    public int compare(Refeicao refeicao1, Refeicao refeicao2) {
                        return super.compare(refeicao1, refeicao2);
                    }
                };
                refeicoesList.add(refeicao);
                Collections.sort(refeicoesList, compararDatas);
                Collections.reverse(refeicoesList);


            }

            ListViewAdapter adapter = new ListViewAdapter(this, R.layout.activity_list_view_adapter, refeicoesList);

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int verif = 0;

                Refeicao refeicao = (Refeicao) parent.getItemAtPosition(position);
                refeicoesListLocal = dao.pesquisarTodos();

                if (verificaConexao()) {

                    if (refeicoesList.isEmpty()) {
                        System.out.println("Teste1");

                        avaliar(refeicao);

                    } else {
                        System.out.println("Teste2");
                        for (int i = 0; i < refeicoesListLocal.size(); i++) {

                            if (refeicao.getId() == refeicoesListLocal.get(i).getId()) {
                                verif = 1;
                                System.out.println("Teste3");

                            } else {

                                System.out.println("Teste4");

                            }
                        }
                        if (verif == 1) {
                            System.out.println("Teste3.1");
                            Toast.makeText(Cardapio.this, "Esta refeição já foi avaliada por você!", Toast.LENGTH_SHORT).show();
                        } else {
                            System.out.println("Teste4.1");
                            avaliar(refeicao);
                        }

                    }

                }else{
                    Toast.makeText(Cardapio.this, "Você necessita de uma conexão com a internet!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void avaliar(Refeicao refeicao) {

        Bundle bundle = new Bundle();
        bundle.putLong("id", refeicao.getId());
        bundle.putString("data", refeicao.getData());
        bundle.putString("tipo", refeicao.getNomeRefeicao());
        bundle.putString("prato principal", refeicao.getPratoPrincipal());
        bundle.putString("acompanhamento", refeicao.getAcompanhamentos());
        bundle.putString("avaliacao", refeicao.getAvaliacao());
        bundle.putString("saladas", refeicao.getSaladas());
        bundle.putString("vegetariana", refeicao.getOpcaoVeg());
        bundle.putString("suco", refeicao.getSuco());
        bundle.putString("sobremesa", refeicao.getSobremesa());
        bundle.putString("guarnicao", refeicao.getGuarnicao());

        bundle.putSerializable("refeicao", refeicao);


        Intent intent = new Intent(getBaseContext(), Avaliar.class);

        intent.putExtra("main", bundle);
        startActivity(intent);

    }

    private void getJSON(String url) {
        class GetJSON extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String result) {

                myJSON = result;
                showList();
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);
    }

    public  boolean verificaConexao() {
        boolean conectado;
        System.out.println("Verificando conexão");
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            System.out.println("Verificando conexão2");
            conectado = true;
        } else {
            System.out.println("Verificando conexão3");
            conectado = false;
        }
        return conectado;
    }

}


