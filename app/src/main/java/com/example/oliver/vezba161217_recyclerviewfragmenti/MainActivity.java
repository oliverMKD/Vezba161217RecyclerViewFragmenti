package com.example.oliver.vezba161217_recyclerviewfragmenti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.oliver.vezba161217_recyclerviewfragmenti.SharedPreferences.User;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text1)
    EditText ime;
    @BindView(R.id.text2)
    EditText prezime;
    @BindView(R.id.kopce1)
    Button kopceNext;
    @BindView(R.id.kopce2)
    Button kopceLoad;
    @BindView(R.id.text3)
    EditText username;
    @BindView(R.id.text4)
    EditText password;
    @BindView(R.id.text5)
    EditText age;
    @BindView(R.id.text6)
    EditText adress;
    @BindView(R.id.slika)
    TextView slika;
    String defaultSlika = "http://simpleicon.com/wp-content/uploads/user1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        slika.setText(defaultSlika);

        kopceNext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ime.setText("");
                prezime.setText("");
                return true;
            }
        });


        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
        String ime = preferences.getString("Ime", "");
        String prezime = preferences.getString("Prezime", "");
    }

    @OnClick(R.id.kopce1)
    public void Vnesi() {

        String imeRezultat = ime.getText().toString();
        String prezimeRezultat = prezime.getText().toString();
        String usernameRezultat = username.getText().toString();
        String passRezultat = password.getText().toString();
        int ageRezultat = Integer.parseInt(age.getText().toString());
        String adressRezultat = adress.getText().toString();
        defaultSlika = slika.getText().toString();
        User user = new User(imeRezultat, prezimeRezultat, usernameRezultat, passRezultat, adressRezultat, ageRezultat, defaultSlika);
        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        preferences.edit().putString("User", mapString).apply();

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
//        preferences.edit().putString("Ime",imeRezultat).apply();
//        preferences.edit().putString("Prezime",prezimeRezultat).apply();


    }

    @OnClick(R.id.kopce2)
    public void Load() {

        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
//        String name = preferences.getString("Ime","");
//        String lastname = preferences.getString("Prezime","");


//        ime.setText(name);
//        prezime.setText(lastname);
        User user1;
        Gson gson = new Gson();
        user1 = gson.fromJson(preferences.getString("User", ""), User.class);
        ime.setText(user1.getName());
        prezime.setText(user1.getLastname());


    }


}
