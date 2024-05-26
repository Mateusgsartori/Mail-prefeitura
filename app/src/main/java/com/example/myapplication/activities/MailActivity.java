package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MailActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private EditText assunto;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        fab = findViewById(R.id.fab);
        assunto = findViewById(R.id.edt_assunto);
        email = findViewById(R.id.edt_corpo);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaEmail();
            }
        });

    }

    private void enviaEmail() {
        if (isEmpty(this.getEmail()) || isEmpty(this.getAssunto())) {
            Toast.makeText(this, "É obrigatório preencher o assunto e o corpo do e-mail!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent enviaEmailIntent = new Intent(Intent.ACTION_SENDTO);
        String email = "mailprefeituratesterecebe@gmail.com";

        enviaEmailIntent.setData(Uri.parse("mailto:"));
        enviaEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        enviaEmailIntent.putExtra(Intent.EXTRA_SUBJECT, this.getAssunto().getText().toString());
        enviaEmailIntent.putExtra(Intent.EXTRA_TEXT, this.getEmail().getText().toString());

        startActivity(enviaEmailIntent);


    }


    private boolean isEmpty(EditText txt) {
        return txt == null || txt.getText().toString().trim().isEmpty();
    }


    public FloatingActionButton getFab() {
        return fab;
    }

    public void setFab(FloatingActionButton fab) {
        this.fab = fab;
    }

    public EditText getAssunto() {
        return assunto;
    }

    public void setAssunto(EditText assunto) {
        this.assunto = assunto;
    }

    public EditText getEmail() {
        return email;
    }

    public void setEmail(EditText email) {
        this.email = email;
    }
}