package com.example.br.edu.ifsp.dmos5.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.br.edu.ifsp.dmos5.R;
import com.example.br.edu.ifsp.dmos5.dao.UserDao;
import com.example.br.edu.ifsp.dmos5.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText;
    private EditText passEditText;
    private Button loginButton;
    private Button signButton;
    private TextView textText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.edittext_user);
        passEditText = findViewById(R.id.edittext_password);
        textText = findViewById(R.id.text_text);

        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(this);

        signButton = findViewById(R.id.button_newuser);
        signButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == loginButton){
            UserDao d = new UserDao();
            String s = getName();
            String p = getPass();
            boolean t;

            t = d.verify(s, p);

            if (t==false){
                Intent intent = new Intent(this, ContactsActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
            }
        }
        if(view == signButton){
            Intent intent = new Intent(MainActivity.this, NewUserActivity.class);
            startActivity(intent);
        }
    }

    private String getName(){
        String value;

        value = nameEditText.getText().toString();

        return value;
    }

    private String getPass(){
        String value;

        value = passEditText.getText().toString();

        return value;
    }
    
}