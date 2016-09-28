package hyteck.com.br.headache;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import hyteck.com.br.headache.dao.HeadacheDao;
import hyteck.com.br.headache.entity.Headache;

public class MainActivity extends AppCompatActivity {

    Button btnSaveHeadache;
    EditText inputDTfim, inputDTini, inputHRini, inputHRfim;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity.this, HeadacheListActivity.class);
//            startActivity(i);
//
//        });


        inputDTfim = (EditText) findViewById(R.id.inputDTfim);
        inputHRfim = (EditText) findViewById(R.id.inputHRfim);
        inputHRini = (EditText) findViewById(R.id.inputHRini);
        inputDTini = (EditText) findViewById(R.id.inputDTini);

        spinner();
        Intent intent = getIntent();

        acaoBotao(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void spinner() {
        // Spinner click listener
        spinner = (Spinner) findViewById(R.id.spinnerIntensidade);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.intensidade_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void acaoBotao(Intent intent) {
        String acao = intent.getStringExtra("acao");

        HeadacheDao dao = new HeadacheDao(this);

        btnSaveHeadache = (Button) findViewById(R.id.btnSaveHead);

        Log.i("acao", acao);
        if (acao.equalsIgnoreCase("inserir")) {

            btnSaveHeadache.setText(R.string.btnSaveHead);

            Date date = new Date();
            SimpleDateFormat df;
            df = new SimpleDateFormat("dd/MM/yyyy");

            inputDTini.setText(df.format(date));
            df = new SimpleDateFormat("HH:mm");
            inputHRini.setText(df.format(date));

            btnSaveHeadache.setOnClickListener(view -> {
                        Headache headache = new Headache();
                        pegarDadosInput(headache);

                        Long result = dao.inserir(headache);

                        Toast.makeText(this, "salvo? " + result, Toast.LENGTH_LONG).show();

                        Intent i = new Intent(MainActivity.this, HeadacheListActivity.class);
                        startActivity(i);

                    }

            );
        } else if (acao.equalsIgnoreCase("editar")) {
            btnSaveHeadache.setText(R.string.btnUpdateHead);


            Headache headache = (Headache) intent.getSerializableExtra("headache");

            PreencherCampos(headache);

            btnSaveHeadache.setOnClickListener(view -> {
                        pegarDadosInput(headache);

                        int result = dao.alterar(headache);

                        Toast.makeText(this, "alterado? " + result + " id: " + headache.getId(), Toast.LENGTH_LONG).show();

                        Intent i = new Intent(MainActivity.this, HeadacheListActivity.class);
                        startActivity(i);

                    }
            );

        }
    }

    public void pegarDadosInput(Headache headache) {

        headache.setHoraInicio(inputHRini.getText().toString());
        headache.setHoraTermino(inputHRfim.getText().toString());
        headache.setDataInicio(inputDTini.getText().toString());
        headache.setDataTermino(inputDTfim.getText().toString());
        headache.setIntensidade(spinner.getSelectedItem().toString());


    }

    public void PreencherCampos(Headache headache) {

        if (headache != null) {
            inputDTfim.setText(headache.getDataTermino());
            inputDTini.setText(headache.getDataInicio());
            inputHRfim.setText(headache.getHoraTermino());
            inputHRini.setText(headache.getHoraInicio());

        } else {
            Toast.makeText(this, "Não foi possível passar os dados", Toast.LENGTH_LONG).show();

        }

    }
}
