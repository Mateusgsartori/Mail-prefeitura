package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Pessoa;
import com.example.myapplication.repository.PessoaRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText usuario, senha, nome, bairro, rua, numero;
    private Button cadastrar;

    private String usuarioStr, senhaStr, nomeStr, ruaStr, bairroStr;
    private Integer numeroInt;

    private PessoaRepository pessoaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cadastrar = findViewById(R.id.btn_cadastrar);

        usuario = findViewById(R.id.edt_user);
        senha = findViewById(R.id.edt_password);
        nome = findViewById(R.id.edt_nome);
        bairro = findViewById(R.id.edt_bairro);
        rua = findViewById(R.id.edt_rua);
        numero = findViewById(R.id.edt_numero);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastraPessoa();
            }
        });

    }

    private void cadastraPessoa() {

        if (isEmpty(this.getUsuario()) || isEmpty(this.getSenha()) || isEmpty(this.getBairro()) || isEmpty(this.getNome()) || isEmpty(this.getRua()) || isEmpty(this.getNumero())) {
            Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
        PessoaRepository pr = new PessoaRepository(this);

        if (pr.checkUser(this.getUsuario().getText().toString(), null)) {
            Toast.makeText(getApplicationContext(), "Usuário já cadastrado!", Toast.LENGTH_SHORT).show();
            return;
        }


        this.setUsuarioStr(this.getUsuario().getText().toString());
        this.setSenhaStr(this.getSenha().getText().toString());
        this.setBairroStr(this.getBairro().getText().toString());
        this.setNomeStr(this.getNome().getText().toString());
        this.setRuaStr(this.getRua().getText().toString());
        this.setNumeroInt(Integer.valueOf(this.getNumero().getText().toString()));
        Pessoa pessoa =  new Pessoa(this.getUsuarioStr(), this.getSenhaStr(), this.getNomeStr(), this.getBairroStr(), this.getRuaStr(), this.getNumeroInt());

        if (pr.insert(pessoa)) {
            startActivity(new Intent(this, LoginActivity.class));
            this.finish();
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

    public EditText getNome() {
        return nome;
    }

    public void setNome(EditText nome) {
        this.nome = nome;
    }

    public EditText getBairro() {
        return bairro;
    }

    public void setBairro(EditText bairro) {
        this.bairro = bairro;
    }

    public EditText getRua() {
        return rua;
    }

    public void setRua(EditText rua) {
        this.rua = rua;
    }

    public EditText getNumero() {
        return numero;
    }

    public void setNumero(EditText numero) {
        this.numero = numero;
    }

    public Button getCadastrar() {
        return cadastrar;
    }

    public void setCadastrar(Button cadastrar) {
        this.cadastrar = cadastrar;
    }

    public String getUsuarioStr() {
        return usuarioStr;
    }

    public void setUsuarioStr(String usuarioStr) {
        this.usuarioStr = usuarioStr;
    }

    public String getSenhaStr() {
        return senhaStr;
    }

    public void setSenhaStr(String senhaStr) {
        this.senhaStr = senhaStr;
    }

    public String getNomeStr() {
        return nomeStr;
    }

    public void setNomeStr(String nomeStr) {
        this.nomeStr = nomeStr;
    }

    public String getRuaStr() {
        return ruaStr;
    }

    public void setRuaStr(String ruaStr) {
        this.ruaStr = ruaStr;
    }

    public String getBairroStr() {
        return bairroStr;
    }

    public void setBairroStr(String bairroStr) {
        this.bairroStr = bairroStr;
    }

    public Integer getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(Integer numeroInt) {
        this.numeroInt = numeroInt;
    }

    public PessoaRepository getPessoaRepository() {
        return pessoaRepository;
    }

    public void setPessoaRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
}