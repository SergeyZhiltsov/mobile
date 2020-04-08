package com.example.laba3456;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Register extends AppCompatActivity {
    public String[] timelist={"20", "40", "60", "120", "180"};
    public Spinner spinnertext;
    public EditText editText;
    public int timercount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Spinner spinnertext = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timelist);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinnertext.setAdapter(adapter);

    }

    public void startclick (View view){

        Intent intent = new Intent(Register.this, MainActivity.class);
        Spinner spinnertext = (Spinner) findViewById(R.id.spinner);
        intent.putExtra("time", Integer.parseInt((String) spinnertext.getSelectedItem()));



        EditText email = (EditText) findViewById(R.id.editText);
        intent.putExtra("email", email.getText().toString());

        startActivity(intent);
    }
}
