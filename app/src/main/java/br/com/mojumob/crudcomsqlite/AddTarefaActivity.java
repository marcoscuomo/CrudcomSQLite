package br.com.mojumob.crudcomsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddTarefaActivity extends AppCompatActivity {

    //Atributos
    private EditText edtNomeTarefa, edtDescricaoTarefa;
    private Button btnAcao;
    private Spinner spinnerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefa);

        //Inicializações

    }
}
