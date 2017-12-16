package com.example.oliver.vezba161217_recyclerviewfragmenti;

import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text1)
    EditText ime;
    @BindView(R.id.text2)
    EditText prezime;
    @BindView(R.id.kopce1)
    Button kopceNext;
    @BindView(R.id.kopce2)
    Button kopceLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

         kopceNext.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View view) {
                 ime.setText("");
                 prezime.setText("");
                 return true;
             }
         });


        SharedPreferences preferences = getSharedPreferences("MyFiles",MODE_PRIVATE);
        String ime = preferences.getString("Ime","");
        String prezime = preferences.getString("Prezime","");
    }

    @OnClick(R.id.kopce1)
    public void Vnesi(){

        String imeRezultat = ime.getText().toString();
        String prezimeRezultat = prezime.getText().toString();
        User user = new User(imeRezultat,prezimeRezultat);
        SharedPreferences preferences = getSharedPreferences("MyFiles",MODE_PRIVATE);
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        preferences.edit().putString("User",mapString).apply();
//        preferences.edit().putString("Ime",imeRezultat).apply();
//        preferences.edit().putString("Prezime",prezimeRezultat).apply();


    }

    @OnClick(R.id.kopce2)
    public void Load(){

        SharedPreferences preferences = getSharedPreferences("MyFiles",MODE_PRIVATE);
//        String name = preferences.getString("Ime","");
//        String lastname = preferences.getString("Prezime","");


//        ime.setText(name);
//        prezime.setText(lastname);
        User user1;
        Gson gson = new Gson();
        user1 = gson.fromJson(preferences.getString("User",""),User.class);
        ime.setText(user1.getName());
        prezime.setText(user1.getLastname());


    }



}
