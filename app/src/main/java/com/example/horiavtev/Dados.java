package com.example.horiavtev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dados#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dados extends Fragment {
    RecyclerView rv;
    AdaptadorDados adaptador;
    Random gerador = new Random();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Dados() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dados.
     */
    // TODO: Rename and change types and number of parameters
    public static Dados newInstance(String param1, String param2) {
        Dados fragment = new Dados();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dados, container, false);
        rv = v.findViewById(R.id.rv);
        ArrayList<Integer> dados = new ArrayList<>();
        dados.add(4);dados.add(6);dados.add(8);dados.add(10);dados.add(12);dados.add(20);dados.add(100);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptador = new AdaptadorDados(getContext(), dados, new AdaptadorDados.OnItemClickListener() {
            @Override
            public void onItemClick(int dado) {
                //int rolagem = gerador.nextInt(dado)+1;
                Toast.makeText(getContext(), dado+"", Toast.LENGTH_SHORT).show();
                //adaptador.setRolagem(rolagem);
            }
        });
        rv.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
        return v;
    }
}