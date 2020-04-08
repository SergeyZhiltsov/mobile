package com.example.laba3456;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

public String email2, message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView emailtext = (TextView) findViewById(R.id.textView3);
       Bundle arguments = getIntent().getExtras();
        emailtext.setText(arguments.getString("email"));

        TextView result = (TextView) findViewById(R.id.textView2);
        TextView resulttimer = (TextView) findViewById(R.id.textView5);


        result.setText(arguments.getString("result"));

        resulttimer.setText(arguments.getString("timer"));
        email2=arguments.getString("email");
        message= "Time: "+arguments.getString("timer").toString()+"\n"+"Result: "+arguments.getString("result").toString();

    }

    public void sendmessage(View view){
        Intent email = new Intent(Intent.ACTION_SEND);
//Указываем получателя
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{email2.toString()});
//Устанавливаем Тему сообщения
        email.putExtra(Intent.EXTRA_SUBJECT, "Game results");
//Устанавливаем само сообщение
        email.putExtra(Intent.EXTRA_TEXT, message);
//тип отправляемого сообщения
        email.setType("message/rfc822");
//Вызываем intent выбора клиента для отправки сообщения
        startActivity(Intent.createChooser(email, "Выберите email клиент :"));
    }
}
