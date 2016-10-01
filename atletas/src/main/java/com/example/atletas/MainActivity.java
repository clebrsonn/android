package com.example.atletas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<Atleta> mAdapter;
    private ListView mLvAtleta;
    public static ArrayList<Atleta> mAtletas = new ArrayList<>();
    private FloatingActionButton mNovoAtleta;
    public static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        loadPeople();
        addAtleta();

        mAdapter = new AtletaAdapter(this, mAtletas);

        // atacha o adapter a list view
        mLvAtleta = (ListView) findViewById(R.id.lvAtletas);
        mLvAtleta.setAdapter(mAdapter);

        // Seta a propria Activity como o Listener
        mLvAtleta.setOnItemClickListener(this);


    }


    private void addAtleta() {
        mNovoAtleta = (FloatingActionButton) findViewById(R.id.fab_fabteste);
        mNovoAtleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

//    private void loadPeople() {
//        mAtletas = new ArrayList<>();
//        for (int i = 0; i < 1; i++) {
//            Atleta atleta = new Atleta("Cleberson", "ouro", "salto", "25", "Brasil");
//            mAtletas.add(atleta);
//            Atleta atleta1 = new Atleta("Teste", "prata", "nado", "25", "Brasil");
//            mAtletas.add(atleta1);
//            Atleta atleta2 = new Atleta("Ares", "bronze", "corrida", "25", "Brasil");
//            mAtletas.add(atleta2);
//
//        }
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Atleta atleta = (Atleta) data.getSerializableExtra("atleta");
            mAtletas.add(atleta);
            mAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(this, R.string.notSAve, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
        intent.putExtra("atletaPosicao", position);
        startActivity(intent);

    }
}
