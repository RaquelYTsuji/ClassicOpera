package com.raquel.projetointegrador;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrincipalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrincipalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView isaura;
    private ImageView moreninha;
    private ImageView narnia;
    private ImageView grim1;
    private ImageView grim2;
    private ImageView casmurro;
    private ImageView iracema;
    private ImageView memorias;
    private ImageView diario;
    private ImageView escaravelho;
    private ImageView magico;
    private ImageView misterioso;

    public PrincipalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrincipalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PrincipalFragment newInstance(String param1, String param2) {
        PrincipalFragment fragment = new PrincipalFragment();
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
        return inflater.inflate(R.layout.fragment_principal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        isaura=view.findViewById(R.id.isaura);
        isaura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zIsauraTexto.class);
                startActivity(intent);
            }
        });

        moreninha=view.findViewById(R.id.moreninha);
        moreninha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zMoreninhaTexto.class);
                startActivity(intent);
            }
        });

        narnia=view.findViewById(R.id.narnia);
        narnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zNarniaTexto.class);
                startActivity(intent);
            }
        });

        grim1=view.findViewById(R.id.grim1);
        grim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zGrim1Texto.class);
                startActivity(intent);
            }
        });

        grim2=view.findViewById(R.id.grim2);
        grim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zGrim2Texto.class);
                startActivity(intent);
            }
        });

        casmurro=view.findViewById(R.id.casmurro);
        casmurro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zCasmurroTexto.class);
                startActivity(intent);
            }
        });

        iracema=view.findViewById(R.id.iracema);
        iracema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zIracemaTexto.class);
                startActivity(intent);
            }
        });

        memorias=view.findViewById(R.id.memorias);
        memorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zMemoriasTexto.class);
                startActivity(intent);
            }
        });

        diario=view.findViewById(R.id.diario);
        diario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zDiarioTexto.class);
                startActivity(intent);
            }
        });

        escaravelho=view.findViewById(R.id.escaravelho);
        escaravelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zEscaravelhoTexto.class);
                startActivity(intent);
            }
        });

        magico=view.findViewById(R.id.magico);
        magico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zMagicoTexto.class);
                startActivity(intent);
            }
        });

        misterioso=view.findViewById(R.id.misterioso);
        misterioso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), zMisteriosoTexto.class);
                startActivity(intent);
            }
        });
    }
}