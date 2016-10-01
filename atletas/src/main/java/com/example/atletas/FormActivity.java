package com.example.atletas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FormActivity extends AppCompatActivity {

    private Button mSalvar;
    private EditText mNome;
    private EditText mIdade;
    private EditText mModalidade;
    private EditText mPais;
    private String mMedalha;
    private Spinner spinner;
    private Atleta atleta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        spinner();
        carregarAtleta();
        mSalvar = (Button) findViewById(R.id.btnSalvar);

        mSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMedalha = spinner.getSelectedItem().toString();

                atleta = new Atleta(mNome.getText().toString(),
                        mMedalha,
                        mModalidade.getText().toString(), mIdade.getText().toString(),
                        mPais.getText().toString());


                Intent intent = new Intent();
                intent.putExtra("atleta", atleta);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

    private void carregarAtleta() {
        mNome = (EditText) findViewById(R.id.etNome);
        mModalidade = (EditText) findViewById(R.id.etModalidade);
        mPais = (EditText) findViewById(R.id.etPais);
        mIdade = (EditText) findViewById(R.id.etIdade);
//        MainActivity.mAtletas.add(atleta);
    }

    public void spinner() {
        // Spinner click listener
        spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.medalhas, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}
