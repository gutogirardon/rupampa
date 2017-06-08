package unipampa.edu.br.rupampa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sugestao extends AppCompatActivity {
    EditText nome, sugestao;
    String str_nome, str_sugestao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao);
        nome = (EditText)findViewById(R.id.editTextNome);
        sugestao = (EditText)findViewById(R.id.editTextSugestao);
    }

    public void enviarSugestao (View view) {
        String str_nome = nome.getText().toString();
        String str_sugestao = sugestao.getText().toString();
        String type = "cadastroSugestao";

        Api api = new Api(this);
        api.execute(type, str_nome, str_sugestao);

    }

    public void setStr_sugestao(String str_sugestao){
        this.str_sugestao = str_sugestao;

    }

    public void voltarMenu (View view) {
        finish();
    }
}