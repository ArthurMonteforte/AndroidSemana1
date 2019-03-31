package br.com.paulosalvatore.pagseguroandroidturmab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.List;

public class RegisterLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_language);

        final EditText etTitle = findViewById(R.id.etTitle);
        final EditText etYear = findViewById(R.id.etYear);
        final EditText etDescription = findViewById(R.id.etDescription);
        final RadioGroup rg = findViewById(R.id.rgLanguages);

        View btRegister = findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadioButtonId = rg.getCheckedRadioButtonId();
                int rbSelected = 0;
                if(checkedRadioButtonId == findViewById(R.id.rbJava).getId()) {
                    rbSelected = R.drawable.java;
                }
                if(checkedRadioButtonId == findViewById(R.id.rbPython).getId()) {
                    rbSelected = R.drawable.python;
                }
                if(checkedRadioButtonId == findViewById(R.id.rbKotlin).getId()) {
                    rbSelected = R.drawable.kotlin;
                }
                if(checkedRadioButtonId == findViewById(R.id.rbCSharp).getId()) {
                    rbSelected = R.drawable.csharp;
                }

                ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(
                        rbSelected,
                        etTitle.getText().toString(),
                        Integer.valueOf(etYear.getText().toString()),
                        etDescription.getText().toString()
                );

                List<ProgrammingLanguage> programmingLanguages = MainActivity.userLanguages.get(Session.LOGGED_USER);
                programmingLanguages.add(programmingLanguage);
                MainActivity.userLanguages.put(Session.LOGGED_USER,programmingLanguages);

                Intent intent = new Intent(RegisterLanguageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
