package unipampa.edu.br.rupampa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Elogio extends AppCompatActivity {
    EditText nome, elogio;
    String str_nome, str_elogio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elogio);
        nome = (EditText)findViewById(R.id.editTextNome);
        elogio = (EditText)findViewById(R.id.editTextElogio);
    }

    public void enviarElogio (View view) {
        String str_nome = nome.getText().toString();
        String str_elogio = elogio.getText().toString();
        String type = "cadastroElogio";

        Api api = new Api(this);
        api.execute(type, str_nome, str_elogio);

    }

    public void voltarMenu (View view) {
        finish();
    }
}
