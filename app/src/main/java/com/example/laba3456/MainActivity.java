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
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
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


import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public TextView mTimer;
   public ToggleButton toogleButton;
    public int count, i, i2, i3, i4;
    public TextView tvInfo, textView;
    public Switch switch1;
    public Button submit, buttonsave;
    public int timercount;
    public String email;
    public CheckBox hidebox;
    public RadioButton radioButton4;
    public Spinner spinner;
    @Override

    public void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView left = (TextView) findViewById(R.id.textViewLeft);
        TextView right = (TextView) findViewById(R.id.textViewRight);




        left.setOnClickListener(viewClickListener);
        right.setOnClickListener(viewClickListener);

        registerForContextMenu(left);
        registerForContextMenu(right);




        Bundle arguments = getIntent().getExtras();
        timercount = arguments.getInt("time")*1000;
     //  timercount = Integer.parseInt(getIntent().getStringExtra("time"));

        int min = 1;
        int max = 3;
        int diff = max - min;
        Random randomcolleft = new Random();
        Random randomcolright = new Random();
        Random randomtextleft = new Random();
        Random randomtextright = new Random();
        i = randomcolleft.nextInt(diff+1);
        i2 = randomcolright.nextInt(diff+1);
        i3 = randomtextleft.nextInt(diff+1);
        i4 = randomtextright.nextInt(diff+1);
        if (i==0){
            left.setTextColor(Color.RED);
        }
        if (i==1){
            left.setTextColor(Color.GREEN);
        }
        if (i==2){
            left.setTextColor(Color.BLUE);
        }

        if (i2==0){
            right.setTextColor(Color.RED);
        }
        if (i2==1){
            right.setTextColor(Color.GREEN);
        }
        if (i2==2){
            right.setTextColor(Color.BLUE);
        }

        if (i3==0){
            left.setText("RED");
        }
        if (i3==1){
            left.setText("GREEN");
        }
        if (i3==2){
            left.setText("BLUE");
        }

        if (i4==0){
            right.setText("RED");
        }
        if (i4==1){
            right.setText("GREEN");
        }
        if (i4==2){
            right.setText("BLUE");
        }


        /*Spinner spinnertext = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timelist);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinnertext.setAdapter(adapter);*/

        final ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
            mTimer = (TextView) findViewById(R.id.timer);
            pb.setMax(timercount/1000);

            new CountDownTimer(timercount, 1000) {

                //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
                public void onTick(long millisUntilFinished) {
                    mTimer.setText("Осталось: "
                            + millisUntilFinished / 1000);
                    int k = (int) millisUntilFinished / 1000;
                    pb.setProgress(k);
                }
                TextView counttext = (TextView) findViewById(R.id.counttext);
                TextView textViewcenter = (TextView) findViewById(R.id.textView);
                public void onFinish() {
                    mTimer.setText("Конец");

                  /*  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Ваш счет!")
                            .setMessage(Integer.toString(count))
                            .setCancelable(false)
                            .setNegativeButton("ОК",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();

                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();*/
                    textViewcenter.setVisibility(View.VISIBLE);

                    counttext.setVisibility(View.VISIBLE);
                    mTimer.setVisibility(View.VISIBLE);
                    RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton4);
                    CheckBox hidebox = (CheckBox) findViewById(R.id.checkBox);
                    switch1 = (Switch) findViewById(R.id.switch1);
                    radio1.setChecked(false);
                    hidebox.setChecked(false);
                    switch1.setChecked(true);

                    Bundle arguments = getIntent().getExtras();
                    email=arguments.getString("email");
                    Intent intent3 = new Intent(MainActivity.this, Result.class);
                    intent3.putExtra("email", email);



                    intent3.putExtra("result", counttext.getText().toString());

                    intent3.putExtra("timer", Integer.toString(timercount/1000));

                    startActivity(intent3);


                    count=0;
                    counttext.setText(Integer.toString(count));

                }
            }
                    .start();


        switch1 = (Switch) findViewById(R.id.switch1);

        submit = (Button) findViewById(R.id.buttonsave);
        submit.setOnClickListener(new View.OnClickListener() {
            TextView counttext = (TextView) findViewById(R.id.counttext);
            @Override

            public void onClick(View view) {
                if (switch1.isChecked())
                counttext.setVisibility(View.VISIBLE);
                else
                    counttext.setVisibility(View.INVISIBLE);

                CheckBox hidebox = (CheckBox) findViewById(R.id.checkBox);
                // Получаем, отмечен ли данный флажок
                boolean checked = hidebox.isChecked();
                if (checked){
                    mTimer.setVisibility(View.INVISIBLE);
                }else{
                    mTimer.setVisibility(View.VISIBLE);
                }

                RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton4);
                TextView textViewcenter = (TextView) findViewById(R.id.textView);
                if (radio1.isChecked()){
                    textViewcenter.setVisibility(View.INVISIBLE);

                }else{

                    textViewcenter.setVisibility(View.VISIBLE);
                }

              /* Spinner spinnertext = (Spinner) findViewById(R.id.spinner2);
                TextView left = (TextView) findViewById(R.id.textViewLeft);
                timercount = Integer.parseInt(spinnertext.getSelectedItem().toString())*1000;*/


            }
        });



        }



    public void LeftClick(View view) {

        TextView left = (TextView) findViewById(R.id.textViewLeft);
        TextView right = (TextView) findViewById(R.id.textViewRight);
        TextView counttext = (TextView) findViewById(R.id.counttext);
        if (i2==i3){
            count++;
        }else {
            count--;
        }
        counttext.setText(Integer.toString(count));
        int min = 1;
        int max = 3;
        int diff = max - min;
        Random randomcolleft = new Random();
        Random randomcolright = new Random();
        Random randomtextleft = new Random();
        Random randomtextright = new Random();
        i = randomcolleft.nextInt(diff+1);
        i2 = randomcolright.nextInt(diff+1);
        i3 = randomtextleft.nextInt(diff+1);
        i4 = randomtextright.nextInt(diff+1);

        if (i==0){
            left.setTextColor(Color.RED);
        }
        if (i==1){
            left.setTextColor(Color.GREEN);
        }
        if (i==2){
            left.setTextColor(Color.BLUE);
        }

        if (i2==0){
            right.setTextColor(Color.RED);
        }
        if (i2==1){
            right.setTextColor(Color.GREEN);
        }
        if (i2==2){
            right.setTextColor(Color.BLUE);
        }

        if (i3==0){
            left.setText("RED");
        }
        if (i3==1){
            left.setText("GREEN");
        }
        if (i3==2){
            left.setText("BLUE");
        }

        if (i4==0){
            right.setText("RED");
        }
        if (i4==1){
            right.setText("GREEN");
        }
        if (i4==2){
            right.setText("BLUE");
        }


    }



    public void RightClick(View view) {

        TextView left = (TextView) findViewById(R.id.textViewLeft);
        TextView right = (TextView) findViewById(R.id.textViewRight);
        TextView counttext = (TextView) findViewById(R.id.counttext);
        if (i2!=i3){
            count++;
        }else {
            count--;
        }
        counttext.setText(Integer.toString(count));
        int min = 1;
        int max = 3;
        int diff = max - min;
        Random randomcolleft = new Random();
        Random randomcolright = new Random();
        Random randomtextleft = new Random();
        Random randomtextright = new Random();
        i = randomcolleft.nextInt(diff+1);
        i2 = randomcolright.nextInt(diff+1);
        i3 = randomtextleft.nextInt(diff+1);
        i4 = randomtextright.nextInt(diff+1);

        if (i==0){
            left.setTextColor(Color.RED);
        }
        if (i==1){
            left.setTextColor(Color.GREEN);
        }
        if (i==2){
            left.setTextColor(Color.BLUE);
        }

        if (i2==0){
            right.setTextColor(Color.RED);
        }
        if (i2==1){
            right.setTextColor(Color.GREEN);
        }
        if (i2==2){
            right.setTextColor(Color.BLUE);
        }

        if (i3==0){
            left.setText("RED");
        }
        if (i3==1){
            left.setText("GREEN");
        }
        if (i3==2){
            left.setText("BLUE");
        }

        if (i4==0){
            right.setText("RED");
        }
        if (i4==1){
            right.setText("GREEN");
        }
        if (i4==2){
            right.setText("BLUE");
        }
    }


    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            mTimer.setText("Состояние: Включён");
        else
            mTimer.setText("Состояние: Выключен");
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        Button buttonsave = (Button) findViewById(R.id.buttonsave);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        CheckBox hidebox = (CheckBox) findViewById(R.id.checkBox);
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.switch1);
        switch(id){
            case R.id.show_settings:
                switch1.setVisibility(View.VISIBLE);
                hidebox.setVisibility(View.VISIBLE);
                radioButton4.setVisibility(View.VISIBLE);
                buttonsave.setVisibility(View.VISIBLE);
                return true;
            case R.id.hide_settings:
                switch1.setVisibility(View.INVISIBLE);
                hidebox.setVisibility(View.INVISIBLE);
                radioButton4.setVisibility(View.INVISIBLE);
                buttonsave.setVisibility(View.INVISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        Button buttonsave = (Button) findViewById(R.id.buttonsave);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        CheckBox hidebox = (CheckBox) findViewById(R.id.checkBox);
        switch (item.getItemId()) {
            // пункты меню для tvColor
            case  R.id.show_settings:
                switch1.setVisibility(View.VISIBLE);
                hidebox.setVisibility(View.VISIBLE);
                radioButton4.setVisibility(View.VISIBLE);
                buttonsave.setVisibility(View.VISIBLE);
                break;
            case R.id.hide_settings:
                switch1.setVisibility(View.INVISIBLE);
                hidebox.setVisibility(View.INVISIBLE);
                radioButton4.setVisibility(View.INVISIBLE);
                buttonsave.setVisibility(View.INVISIBLE);
                break;

        }
        return super.onContextItemSelected(item);
    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.main_menu);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    Switch switch1 = (Switch) findViewById(R.id.switch1);
                    Button buttonsave = (Button) findViewById(R.id.buttonsave);
                    RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
                    CheckBox hidebox = (CheckBox) findViewById(R.id.checkBox);
                    @Override

                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.show_settings:
                                switch1.setVisibility(View.VISIBLE);
                                hidebox.setVisibility(View.VISIBLE);
                                radioButton4.setVisibility(View.VISIBLE);
                                buttonsave.setVisibility(View.VISIBLE);
                                return true;

                            case R.id.hide_settings:
                                switch1.setVisibility(View.INVISIBLE);
                                hidebox.setVisibility(View.INVISIBLE);
                                radioButton4.setVisibility(View.INVISIBLE);
                                buttonsave.setVisibility(View.INVISIBLE);
                                return true;

                        } return true;
                    }

                });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "Dismiss",
                        Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }

}
