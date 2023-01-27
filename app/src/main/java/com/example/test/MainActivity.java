package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private static final String TAG = "MainActivity";

    private EditText inputBIN;
    private Button btnGetInfo;
    private TextView cardInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getCards().observe(
                this,
                cards -> Log.d(TAG, cards)
        );
        viewModel.loadCardInfo();
        }

    public void initViews() {
        inputBIN = findViewById(R.id.inputBIN);
        btnGetInfo = findViewById(R.id.btnGetInfo);
        cardInfo = findViewById(R.id.cardInfo);
    }

}


