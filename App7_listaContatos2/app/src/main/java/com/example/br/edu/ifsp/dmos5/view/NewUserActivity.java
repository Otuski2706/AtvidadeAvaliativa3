package com.example.br.edu.ifsp.dmos5.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.br.edu.ifsp.dmos5.R;
import com.example.br.edu.ifsp.dmos5.dao.UserDao;
import com.example.br.edu.ifsp.dmos5.model.User;

public class NewUserActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText userEdittext;
    private EditText passEdittext;
    private EditText confirmEdittext;
    private Button signButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        userEdittext = findViewById(R.id.edittext_username);

        passEdittext = findViewById(R.id.edittext_create_password);

        confirmEdittext = findViewById(R.id.edittext_confirm_password);

        signButton = findViewById(R.id.button_save);
        signButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == signButton){

            UserDao d = new UserDao();
            String s = getName();
            String p = getPass();
            String c = getConfirm();


            if (c!=p) {
                Toast.makeText(this, getString(R.string.confirm_error), Toast.LENGTH_SHORT).show();
            } else {
                d.addUser(s, p);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    private String getName(){
        String value;

        value = userEdittext.getText().toString();

        return value;
    }

    private String getPass(){
        String value;

        value = passEdittext.getText().toString();

        return value;
    }

    private String getConfirm(){
        String value;

        value = confirmEdittext.getText().toString();

        return value;
    }

}
