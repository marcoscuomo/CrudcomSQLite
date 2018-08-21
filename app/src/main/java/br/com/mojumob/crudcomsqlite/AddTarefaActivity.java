package br.com.mojumob.crudcomsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.mojumob.crudcomsqlite.helper.Common;
import br.com.mojumob.crudcomsqlite.model.Tarefa;

public class AddTarefaActivity extends AppCompatActivity {

    //Atributos
    private EditText edtNomeTarefa, edtDescricaoTarefa;
    private Button btnAcao;
    private Spinner spinnerStatus;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefa);

        //Inicializações
        edtNomeTarefa      = findViewById(R.id.addTarefa_edtNomeTarefa);
        edtDescricaoTarefa = findViewById(R.id.addTarefa_edtDescricaoTarefa);
        spinnerStatus      = findViewById(R.id.addTarefa_spinnerStatus);
        btnAcao            = findViewById(R.id.addTarefa_btnAcao);

        configuraSpinner();

        //Pegando a Tarefa vindo da MainActivuty
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra(Common.INTENT_TAREFA_SELECIONADA);


        //Preenchendo as caixas de textos caso sejam uma atualização
        if(tarefaAtual != null){

            //Configurando a posicição do spinner
            int indiceSpinner;
            if(tarefaAtual.getStatusTarefa().equals(Common.A_FAZER)){
                indiceSpinner = Common.A_FAZER_POSITION;
            }else if(tarefaAtual.getStatusTarefa().equals(Common.FAZENDO)){
                indiceSpinner = Common.FAZENDO_POSITION;
            }else{
                indiceSpinner = Common.FEITO_POSITION;
            }


            edtNomeTarefa.setText(tarefaAtual.getNomeTarefa());
            edtDescricaoTarefa.setText(tarefaAtual.getDescricaoTarefa());
            spinnerStatus.setSelection(indiceSpinner);
        }


        btnAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Capturando o item selecionado do spinner
                String x = spinnerStatus.getSelectedItem().toString();

                Toast.makeText(AddTarefaActivity.this, x, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void configuraSpinner() {
        //Configurando o Spinner
        ArrayAdapter adapterSpinner = ArrayAdapter.createFromResource(AddTarefaActivity.this,
                R.array.status, R.layout.spinner_item);
        adapterSpinner.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerStatus.setAdapter(adapterSpinner);
    }
}
