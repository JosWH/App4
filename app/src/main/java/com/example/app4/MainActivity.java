package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BooleanSupplier;

public class MainActivity extends AppCompatActivity {
    private EditText ETword;
    private Button BTNprocess, BTNcount;
    private CheckBox CBlowerCase;
    private String word;
    private Boolean isLowerCase;
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
        int counter = 0;
        if ( word.length() > 0) {
            ArrayList<Character> vocals =  new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            for (int i = 0; i < word.length(); i++) {
                // if (vocals.contains(word.toLowerCase().charAt(i))) counter++; // Sin usar el metodo de convertir a minusculas
                if (vocals.contains(word.charAt(i))) counter++;
            }
            Toast.makeText(this,"La palabra tiene " + counter + " vocales",Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(this,"El espacio para verificar vocales esta vacio",Toast.LENGTH_LONG).show();
        /* if ( word.length() > 0) {
            for (int i = 0; i < word.length(); i++) {
                char letra = word.charAt(i);
                if (letra == 'a' || letra == 'A') counter += 1;
                if (letra == 'e' || letra == 'E') counter += 1;
                if (letra == 'i' || letra == 'I') counter += 1;
                if (letra == 'o' || letra == 'O') counter += 1;
                if (letra == 'u' || letra == 'U') counter += 1;
            }
            Toast.makeText(this,"La palabra tiene " + counter + " vocales",Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(this,"El espacio para verificar vocales esta vacio",Toast.LENGTH_LONG).show();*/
    }

    private void catchInformation() {
        word = ETword.getText().toString();
        isLowerCase = CBlowerCase.isChecked();
        changeWordLowerCase();
    }

    private void changeWordLowerCase() {
        if (isLowerCase) word = word.toLowerCase();
    }

    private void initViews() {
        ETword = findViewById(R.id.ETword);
        CBlowerCase = findViewById(R.id.CBlowercase);
        BTNprocess = findViewById(R.id.BTNprocess);
        BTNcount = findViewById(R.id.BTNcount);
    }
}