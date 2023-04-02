package com.example.br.edu.ifsp.dmos5.model;

public class Contact {
    int i = 0;
    public String apelido;
    public String nome;
    public String telefone;
    private int id;

    public Contact(String apelido, String nome, String telefone, int id) {
        this.apelido = apelido;
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome=" + nome +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}