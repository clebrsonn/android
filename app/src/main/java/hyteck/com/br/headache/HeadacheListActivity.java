package hyteck.com.br.headache;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hyteck.com.br.headache.dao.HeadacheDao;
import hyteck.com.br.headache.entity.Headache;

public class HeadacheListActivity extends AppCompatActivity implements ClickRecyclerViewInterface {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerHeadache adapter;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache_list);

        setaRecyclerView();

        setaButtons();
        listenersButtons();


    }

    @Override
    public void onCustomClick(Object Object) {
        Headache headache = (Headache) Object;
        Intent intent = new Intent(HeadacheListActivity.this, MainActivity.class);
        intent.putExtra("headache", headache);
        intent.putExtra("acao", "editar");
        Toast.makeText(this, String.valueOf(headache.getId()), Toast.LENGTH_SHORT).show();
        startActivity(intent);


    }

    public void setaRecyclerView() {
        HeadacheDao dao = new HeadacheDao(this);
        List<Headache> headaches = (dao.consultar());
        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerHeadache(this, headaches, this);
        mRecyclerView.setAdapter(adapter);
    }


    public void setaButtons() {

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fabteste);

    }

    public void listenersButtons() {
        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(HeadacheListActivity.this, MainActivity.class);
            intent.putExtra("acao", "inserir");
            startActivity(intent);
//                adapter.notifyDataSetChanged();

        });
    }


}
