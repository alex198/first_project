package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private EditText inputBIN;
    private Button btnGetInfo;
    private TextView cardInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        }

    public void initViews() {
        inputBIN = findViewById(R.id.inputBIN);
        btnGetInfo = findViewById(R.id.btnGetInfo);
        cardInfo = findViewById(R.id.cardInfo);
    }
}


