package hyteck.com.br.deinfo_helpdesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button selecionarCurso;
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selecionarCurso = (Button) findViewById(R.id.btn_curso);

        selecionarCurso.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SelCursoActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String nomeCurso = data.getStringExtra("nomeCurso");
            selecionarCurso.setText(nomeCurso);
        } else {
            selecionarCurso.setText(R.string.shit);
        }
    }
}
