package com.example.horiavtev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDados extends RecyclerView.Adapter<AdaptadorDados.MyViewHolder> {
    Context context;
    ArrayList<Integer> dados;
    AdaptadorDados.OnItemClickListener listener;

    public AdaptadorDados(Context context, ArrayList<Integer> dados, OnItemClickListener listener) {
        this.context = context;
        this.dados = dados;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.dados,parent,false);
        return new AdaptadorDados.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int dado = dados.get(position);
        holder.lados.setText("D " + dado);
        switch (dado) {
            case 4:
                holder.cl.setBackgroundResource(R.drawable.d4);
                break;
            case 6:
                holder.cl.setBackgroundResource(R.drawable.d6);
                break;
            case 8:
                holder.cl.setBackgroundResource(R.drawable.d8);
                break;
            case 10:
                holder.cl.setBackgroundResource(R.drawable.d10);
                break;
            case 12:
                holder.cl.setBackgroundResource(R.drawable.d12);
                break;
            case 20:
                holder.cl.setBackgroundResource(R.drawable.d20);
                break;
            case 100:
                holder.cl.setBackgroundResource(R.drawable.d100);
                break;
        }
        holder.rolagem.setText("");
        listener.onItemClick(dado);
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int dado);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout cl;
        TextView lados, rolagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cl = itemView.findViewById(R.id.dado);
            lados = itemView.findViewById(R.id.lados);
            rolagem = itemView.findViewById(R.id.rolagem);
        }
    }
}
