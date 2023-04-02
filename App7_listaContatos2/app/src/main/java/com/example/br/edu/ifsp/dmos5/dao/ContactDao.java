package com.example.br.edu.ifsp.dmos5.dao;

import com.example.br.edu.ifsp.dmos5.model.Contact;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactDao{

    private final List<Contact> database;

    public ContactDao() {
        database = new ArrayList<>();
    }

    public void addContact(String a, String s, String t, int i) {
        if(verify(a, i)){
            Contact contact = new Contact(a, s, t, i);
            database.add(contact);
            System.out.println("oi");
        }else{
            System.out.println("Não pode");
        }
    }

    public boolean verify(String a, int i) {

        if (BuscaContato((ArrayList<Contact>) database, a, i)==1){
            System.out.println("oi");
            return false;
        }else{
            return true;
        }
    }

    public boolean verifyApel(String a) {

        if (BuscaString((ArrayList<Contact>) database, a)==1){
            System.out.println("oi");
            return false;
        }else{
            return true;
        }
    }

    public static int BuscaContato(ArrayList<Contact> lista, String busca, int n) {
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getApelido().equals(busca)){
                if (n == lista.get(i).getId()){
                    return 1;
                }
            }}
        return 0;
    }

    public static int BuscaString(ArrayList<Contact> lista, String busca) {
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getApelido().equals(busca)){
                return 1;
            }}
        return 0;
    }

    public static int BuscaId(ArrayList<Contact> lista, int in) {

        for (int i = 0; i < lista.size(); i++){
            if (in == lista.get(i).getId()){
                return 1;
            }}
        return 0;
    }

    public boolean verifyContact(String u, String a, String p){
        UserDao d = new UserDao();
        ContactDao c = new ContactDao();

        if(d.verify(u, p)==false){

            int i;
            i=d.ID(u);
            if(c.verify(a, i)==false){
                return true;
            }
        }
        return false;
    }

    public String getNome(String a){
        String nome;
        nome= getN((ArrayList<Contact>) database, a);
        return  nome;
    }

    public String getTelefone(String a){
        String telefone;
        telefone= getT((ArrayList<Contact>) database, a);
        return  telefone;
    }

    public String getN(ArrayList<Contact> lista, String a){
        int i;
        String telefone;
        for (i = 0; i < lista.size(); i++){
            if (lista.get(i).getApelido().equals(a)){
                return lista.get(i).getNome();
            }}
        return "n";
    }

    public String getT(ArrayList<Contact> lista, String a){
        int i;
        String telefone;
        for (i = 0; i < lista.size(); i++){
            if (lista.get(i).getApelido().equals(a)){
                return lista.get(i).getTelefone();
            }}
        return "n";
    }

}