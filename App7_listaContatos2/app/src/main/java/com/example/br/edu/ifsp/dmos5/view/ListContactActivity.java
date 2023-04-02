package com.example.br.edu.ifsp.dmos5.view;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.br.edu.ifsp.dmos5.R;
import com.example.br.edu.ifsp.dmos5.dao.ContactDao;
import com.example.br.edu.ifsp.dmos5.dao.UserDao;

public class ListContactActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userEditText;
    private EditText passEditText;
    private EditText apeEditText;
    private Button button_new;
    private TextView nome_text;
    private TextView numero_text;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);

        userEditText = findViewById(R.id.edit_search_user);
        passEditText = findViewById(R.id.edit_search_pass);
        apeEditText = findViewById(R.id.edit_search_ape);
        nome_text = findViewById(R.id.nome_text);
        numero_text = findViewById(R.id.numero_text);

        button_new = findViewById(R.id.button_new);
        button_new.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == button_new){
            ContactDao c = new ContactDao();
            String n = getName();
            String p = getPass();
            String a = getApe();
            boolean b;
            String t;
            String u;

            b=c.verifyContact(n, a, p);

            if(b){
                nome_text.setText(String.format("Contato: %s", c.getNome(a)));
                numero_text.setText(String.format("Telefone: %s", c.getTelefone(a)));
            }else{
                Toast.makeText(this, getString(R.string.id_error), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getName(){
        String value;

        value = userEditText.getText().toString();

        return value;
    }

    private String getPass(){
        String value;

        value = passEditText.getText().toString();

        return value;
    }

    private String getApe(){
        String value;

        value = apeEditText.getText().toString();

        return value;
    }
}
