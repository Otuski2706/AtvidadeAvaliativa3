package com.example.br.edu.ifsp.dmos5.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.br.edu.ifsp.dmos5.model.User;

public class UserDao {

    private final List<User> database;

    public UserDao(){
        database = new ArrayList<>();

        database.add(new User(1, "pedro", "1234"));
    }

    public void addUser(String s, String p) {
        int i = database.size()+1;
        if(verify(s, p)){
            User user = new User(i, s, p);
            database.add(user);
            System.out.println("oi");
        }else{
            System.out.println("Não pode");
        }
    }

    public boolean verify(String s, String p) {

        if (BuscaString((ArrayList<User>) database, s)==1 && BuscaSenha((ArrayList<User>) database, p)==1){
            System.out.println("oi");
            return false;
        }else{
            return true;
        }
    }

    public boolean verifySign(String s, String p) {

        if (BuscaString((ArrayList<User>) database, s)==1){
            return false;
        }else{
            System.out.println("oi");
            return true;
        }
    }

    public static int BuscaString(ArrayList<User> lista, String busca) {
        for (int i = 0; i < lista.size(); i++){
            //System.out.println(lista.get(i));
            if (lista.get(i).getNome().equals(busca)){
                return 1;
            }}
        return 0;
    }

    public static int BuscaSenha(ArrayList<User> lista, String busca) {
        for (int i = 0; i < lista.size(); i++){
            //System.out.println(lista.get(i));
            if (lista.get(i).getSenha().equals(busca)){
                return 1;
            }}
        return 0;
    }

    public static int BuscaId(ArrayList<User> lista, String busca) {
        for (int i = 0; i < lista.size(); i++){
            //System.out.println(lista.get(i));
            if (lista.get(i).getNome().equals(busca)){

                int idNome = lista.get(i).getId();
                return idNome;
            }}
        return -1;
    }

    public int ID(String nome){
        int id = BuscaId((ArrayList<User>) database, nome);
        return id;
    }
}