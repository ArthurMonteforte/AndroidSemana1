package br.com.paulosalvatore.pagseguroandroidturmab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    public static List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();

    public static Map<String, List<ProgrammingLanguage>> userLanguages = new HashMap();

    static {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(
                R.drawable.java,
                "Java",
                1996,
                "Java Description");

        programmingLanguages.add(programmingLanguage);

        userLanguages.put("foo@example.com", programmingLanguages);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvTitle = v.findViewById(R.id.tvTitle);
                Toast.makeText(MainActivity.this, "Clicked item: " + tvTitle.getText(), Toast.LENGTH_LONG).show();
            }
        };

        if(userLanguages.get(Session.LOGGED_USER) == null) {
            List<ProgrammingLanguage> prog = new ArrayList<>();
            prog.add(new ProgrammingLanguage(
                    R.drawable.java,
                    "Java",
                    1996,
                    "Java Description"));
            userLanguages.put(Session.LOGGED_USER, prog);
        }

        RecyclerView.Adapter adapter = new ProgrammingLanguageAdapter(userLanguages.get(Session.LOGGED_USER), listener);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterLanguageActivity.class);
                startActivity(intent);
            }
        });
    }
}
