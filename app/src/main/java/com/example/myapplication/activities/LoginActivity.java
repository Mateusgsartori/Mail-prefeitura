package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.repository.PessoaRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;
    private Button btnLogin;
    private TextView txtCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.edt_user);
        senha = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        txtCadastrar = findViewById(R.id.txt_cadastrar);

        txtCadastrar.setOnClickListener(v -> startActivity(new Intent(v.getContext(), RegisterActivity.class)));

        btnLogin.setOnClickListener(v -> login());
    }

    private void login() {

        if (isEmpty(this.getUsuario()) || isEmpty(this.getSenha())) {
            Toast.makeText(this, "Preencha usuário e senha!", Toast.LENGTH_SHORT).show();
        }

        PessoaRepository pr = new PessoaRepository(this);
        if (pr.checkUser(this.getUsuario().getText().toString(), this.getSenha().getText().toString())) {
            startActivity(new Intent(this, MailActivity.class));
        } else {
            Toast.makeText(this, "Usuário ou senha não encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmpty(EditText txt) {
        return txt == null || txt.getText().toString().trim().isEmpty();
    }

    public EditText getUsuario() {
        return usuario;
    }

    public void setUsuario(EditText usuario) {
        this.usuario = usuario;
    }

    public EditText getSenha() {
        return senha;
    }

    public void setSenha(EditText senha) {
        this.senha = senha;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    public TextView getTxtCadastrar() {
        return txtCadastrar;
    }

    public void setTxtCadastrar(TextView txtCadastrar) {
        this.txtCadastrar = txtCadastrar;
    }
}