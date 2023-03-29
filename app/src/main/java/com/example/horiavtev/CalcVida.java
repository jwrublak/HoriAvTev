package com.example.horiavtev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalcVida#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalcVida extends Fragment {
    EditText lvl, inicial, constituicao;
    Button calc;
    TextView resultado;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalcVida() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalcVida.
     */
    // TODO: Rename and change types and number of parameters
    public static CalcVida newInstance(String param1, String param2) {
        CalcVida fragment = new CalcVida();
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
        View v = inflater.inflate(R.layout.fragment_calc_vida, container, false);
        inicial = v.findViewById(R.id.inicial);
        lvl = v.findViewById(R.id.nivel);
        constituicao = v.findViewById(R.id.constituicao);
        resultado = v.findViewById(R.id.resultado);
        calc = v.findViewById(R.id.btnCalc);
        calc.setOnClickListener(view ->{
            calcula();
        });
        return v;
    }

    private void calcula() {
        int i = Integer.parseInt(inicial.getText().toString());
        int n = Integer.parseInt(lvl.getText().toString());
        int c = Integer.parseInt(constituicao.getText().toString());
        int r = (i+c)+(((i/2)+1+c)*(n-1));
        resultado.setText("Pontos de vida: "+r);
    }
}