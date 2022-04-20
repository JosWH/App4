package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.function.BooleanSupplier;

public class MainActivity extends AppCompatActivity {
    private EditText ETword;
    private Button BTNprocess, BTNcount;
    private CheckBox CBlowerCase;
    private String word, message;
    private Boolean isLowerCase;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        BTNprocess.setOnClickListener(view -> catchInformation());
        BTNcount.setOnClickListener(view -> countVocals());
    }

    private void countVocals() {
        catchInformation();
        if (word.contains("a") || word.contains("A")){
            counter += 1;
        }
        if (word.contains("e") || word.contains("E")){
            counter += 1;
        }
        if (word.contains("i") || word.contains("I")){
            counter += 1;
        }
        if (word.contains("o") || word.contains("O")){
            counter += 1;
        }
        if (word.contains("u") || word.contains("U")){
            counter += 1;
        }
        message = "La palabra tiene " + this.counter + " vocales";
        counter = 0;
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    private void catchInformation() {
        word = ETword.getText().toString();
        isLowerCase = CBlowerCase.isChecked();
    }

    private void initViews() {
        ETword = findViewById(R.id.ETword);

        CBlowerCase = findViewById(R.id.CBlowercase);

        BTNprocess = findViewById(R.id.BTNprocess);
        BTNcount = findViewById(R.id.BTNcount);
    }
}