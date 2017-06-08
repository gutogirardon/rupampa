package unipampa.edu.br.rupampa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Reclamacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamacao);
    }

    public void voltarMenu (View view) {
        finish();
    }
}
