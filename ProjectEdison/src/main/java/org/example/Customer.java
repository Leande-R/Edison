package org.example;

public class Customer {

    private int id;
    private String name;
    private String mail;
    private double credit;

    public Customer() {
    }
    public Customer(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }


    public Customer(int id, String name, String mail, double credit) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = name;
    }



    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void topUpCredit(double amount) {
        this.credit += amount;
    }



}

