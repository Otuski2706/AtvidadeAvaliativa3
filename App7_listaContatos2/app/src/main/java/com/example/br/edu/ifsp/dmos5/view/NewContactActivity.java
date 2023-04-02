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
import com.example.br.edu.ifsp.dmos5.dao.ContactDao;
import com.example.br.edu.ifsp.dmos5.dao.UserDao;
import com.example.br.edu.ifsp.dmos5.model.User;

public class NewContactActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText apelidoEditText;
    private EditText nameEditText;
    private EditText telEditText;

    private EditText useEditText;
    private Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        apelidoEditText = findViewById(R.id.edittext_apelido);
        nameEditText = findViewById(R.id.edittext_newcontact);
        telEditText = findViewById(R.id.edittext_create_tel);
        useEditText = findViewById(R.id.edittext_user);

        newButton = findViewById(R.id.button_save);
        newButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == newButton){
            ContactDao c = new ContactDao();
            UserDao d = new UserDao();
            String a = getApelido();
            String n = getName();
            String t = getTel();
            String u = getUser();
            int i=0;

            i=d.ID(u);

            if(i!=-1){
                c.addContact(a, n, t, i);
                Intent intent = new Intent(this, ContactsActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, getString(R.string.user_error), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getApelido(){
        String value;

        value = apelidoEditText.getText().toString();

        return value;
    }

    private String getName(){
        String value;

        value = nameEditText.getText().toString();

        return value;
    }

    private String getTel(){
        String value;

        value = telEditText.getText().toString();

        return value;
    }

    private String getUser(){
        String value;

        value = useEditText.getText().toString();

        return value;
    }
}
