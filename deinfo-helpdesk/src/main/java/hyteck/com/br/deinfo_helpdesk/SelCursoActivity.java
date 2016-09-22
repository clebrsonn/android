package hyteck.com.br.deinfo_helpdesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelCursoActivity extends AppCompatActivity {


    Button selecionarCurso;
    RadioGroup radioGroup;
    RadioButton radioButtonSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel_curso);

        selecionarCurso = (Button) findViewById(R.id.btnSelCursoRadio);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        selecionarCurso.setOnClickListener(view -> {
            int radioSelected = radioGroup.getCheckedRadioButtonId();

            radioButtonSelected = (RadioButton) findViewById(radioSelected);

            Intent intent = new Intent();
            intent.putExtra("nomeCurso", radioButtonSelected.getText());
            setResult(RESULT_OK, intent);
            finish();

        });
    }
}
