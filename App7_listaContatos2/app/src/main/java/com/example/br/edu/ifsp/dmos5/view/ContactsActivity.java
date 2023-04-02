package com.example.br.edu.ifsp.dmos5.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.br.edu.ifsp.dmos5.R;
import com.example.br.edu.ifsp.dmos5.dao.ContactDao;
import com.example.br.edu.ifsp.dmos5.model.Contact;

import java.util.List;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button listButton;
    private Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        listButton = findViewById(R.id.button_list);
        listButton.setOnClickListener(this);

        newButton = findViewById(R.id.button_new);
        newButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == listButton){
            Intent intent = new Intent(this, ListContactActivity.class);
            startActivity(intent);
        }
        if(view == newButton){
            Intent intent = new Intent(this, NewContactActivity.class);
            startActivity(intent);
        }
    }

}