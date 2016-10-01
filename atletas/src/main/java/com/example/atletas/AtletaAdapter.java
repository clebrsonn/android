package com.example.atletas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by clebr on 27/09/2016.
 */

public class AtletaAdapter extends ArrayAdapter<Atleta> {

    public AtletaAdapter(Context context, ArrayList<Atleta> atletas) {
        super(context, 0, atletas);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Atleta atleta = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.atleta_list_item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvNome);
        TextView mModalidade = (TextView) convertView.findViewById(R.id.tvModalidade);
        ImageView tvHome = (ImageView) convertView.findViewById(R.id.imageViewMedalha);

        // 4 - preenche os dados
        tvName.setText(atleta.nome);
        mModalidade.setText(atleta.modalidade);
        String medalha = atleta.medalha;
        switch (medalha.toLowerCase()) {
            case "ouro":
                tvHome.setImageResource(R.drawable.ouro);
                break;
            case "prata":
                tvHome.setImageResource(R.drawable.prata);
                break;
            case "bronze":
                tvHome.setImageResource(R.drawable.bronze);
                break;
        }


        return convertView;
    }

}
