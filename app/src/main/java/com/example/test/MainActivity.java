package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //bin для тестов Visa 4000 0012, MasterCard 5110 0001, Из задания 4571 7360
    private MainViewModel viewModel;
    private final String CHECK_BIN_TEXT = "BIN карты должен содержать от 6 до 8 цифр";

    private EditText editTextBIN;
    private Button buttonGetInfo;
    private RecyclerView recyclerViewCardInfo;
    private RecyclerAdapter recyclerAdapter;
    private CardDatabase cardDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        cardDatabase = CardDatabase.getInstance(getApplication());

        buttonGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bin = editTextBIN.getText().toString().trim();
                if (bin.isEmpty() || bin.length() < 6) {
                    Toast.makeText(
                        MainActivity.this,
                        CHECK_BIN_TEXT,
                        Toast.LENGTH_LONG
                    ).show();
                } else {
                    viewModel.loadCardInfo(bin);
                }
            }
        });
        recyclerAdapter = new RecyclerAdapter();
        recyclerViewCardInfo.setAdapter(recyclerAdapter);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getCards().observe(
            this,
            (cards) -> recyclerAdapter.setList(cards)
        );
    }

    public void initViews() {
        editTextBIN = findViewById(R.id.editTextBIN);
        buttonGetInfo = findViewById(R.id.buttonGetInfo);
        recyclerViewCardInfo = findViewById(R.id.recyclerViewCardInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}


