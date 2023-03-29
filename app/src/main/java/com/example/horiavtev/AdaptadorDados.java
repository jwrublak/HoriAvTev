package com.example.horiavtev;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class AdaptadorDados extends RecyclerView.Adapter<AdaptadorDados.MyViewHolder> {
    Context context;
    ArrayList<Integer> dados;
    AdaptadorDados.OnItemClickListener listener;
    Random gerador = new Random();

    public AdaptadorDados(Context context, ArrayList<Integer> dados) {
        this.context = context;
        this.dados = dados;

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
                holder.iv.setBackgroundResource(R.drawable.d4);
                break;
            case 6:
                holder.iv.setBackgroundResource(R.drawable.d6);
                break;
            case 8:
                holder.iv.setBackgroundResource(R.drawable.d8);
                break;
            case 10:
                holder.iv.setBackgroundResource(R.drawable.d10);
                break;
            case 12:
                holder.iv.setBackgroundResource(R.drawable.d12);
                break;
            case 20:
                holder.iv.setBackgroundResource(R.drawable.d20);
                break;
            case 100:
                holder.iv.setBackgroundResource(R.drawable.d100);
                break;
        }
        holder.rolagem.setText("");
        holder.itemView.setOnClickListener(view->{
            int resultado = gerador.nextInt(dado)+1;
            if(dado == 20){
                switch (resultado){
                    case 1:
                        holder.rolagem.setTextColor(Color.RED);
                        break;
                    case 20:
                        holder.rolagem.setTextColor(Color.GREEN);
                        break;
                    default:
                        holder.rolagem.setTextColor(Color.BLACK);
                        break;
                }
            }
            holder.rolagem.setText(String.valueOf(resultado));
        });
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int dado);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView lados, rolagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.dado);
            lados = itemView.findViewById(R.id.lados);
            rolagem = itemView.findViewById(R.id.rolagem);
        }
    }
}
