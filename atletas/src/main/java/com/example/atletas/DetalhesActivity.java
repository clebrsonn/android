package com.example.atletas;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    private TextView mModalidade, mPais, mIdade, mNome;
    private ImageView mMedalha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();
        int position = intent.getIntExtra("atletaPosicao", 0);

        Atleta atleta = MainActivity.mAtletas.get(position);

        mIdade = (TextView) findViewById(R.id.detIdade);
        mNome = (TextView) findViewById(R.id.detNome);
        mMedalha = (ImageView) findViewById(R.id.detMedalha);
        mModalidade = (TextView) findViewById(R.id.detModalidade);
        mPais = (TextView) findViewById(R.id.detPais);
        mModalidade.setText(atleta.modalidade);
        mPais.setText(atleta.pais);
        mIdade.setText(atleta.idade);
        mNome.setText(atleta.nome);

        switch (atleta.medalha.toLowerCase()) {
            case "ouro":
                mMedalha.setImageResource(R.drawable.ouro);
                break;
            case "prata":
                mMedalha.setImageResource(R.drawable.prata);
                break;
            case "bronze":
                mMedalha.setImageResource(R.drawable.bronze);
                break;
        }


    }
}
