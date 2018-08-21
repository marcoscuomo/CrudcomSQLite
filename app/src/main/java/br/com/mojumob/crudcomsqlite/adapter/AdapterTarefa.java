package br.com.mojumob.crudcomsqlite.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import br.com.mojumob.crudcomsqlite.R;
import br.com.mojumob.crudcomsqlite.model.Tarefa;

public class AdapterTarefa extends RecyclerView.Adapter<AdapterTarefa.MyViewHolder> {

    private Context context;
    private List<Tarefa> listaTarefas;

    public AdapterTarefa(Context context, List<Tarefa> listaTarefas) {
        this.context = context;
        this.listaTarefas = listaTarefas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_dados, viewGroup, false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        Tarefa tarefa = listaTarefas.get(i);
        String status = tarefa.getStatusTarefa().toString();

        holder.txtTarefa.setText(tarefa.getNomeTarefa().toString());
        holder.txtStatus.setText(status);
        //holder.txtStatus.setTextColor(ContextCompat.getColor(context, R.color.colorFeito));

        if(status == context.getString(R.string.a_fazer)){
            holder.txtStatus.setTextColor(ContextCompat.getColor(context, R.color.colorAFazer));
        }else if(status == context.getString(R.string.fazendo)){
            holder.txtStatus.setTextColor(ContextCompat.getColor(context, R.color.colorFazendo));
        }else{
            holder.txtStatus.setTextColor(ContextCompat.getColor(context, R.color.colorFeito));
        }

    }

    @Override
    public int getItemCount() {
        return listaTarefas.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTarefa;
        private TextView txtStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTarefa = itemView.findViewById(R.id.adapter_txtTarefa);
            txtStatus = itemView.findViewById(R.id.adapter_txtStatus);
        }
    }

}
