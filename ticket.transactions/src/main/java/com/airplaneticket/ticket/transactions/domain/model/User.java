package com.airplaneticket.ticket.transactions.domain.model;


public class User {

    private int idUser;
    private String username;

    public User(int idUser, String username) {
        this.idUser = idUser;
        this.username = username;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
