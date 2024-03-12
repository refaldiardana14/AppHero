package com.app.refalditugas2;

public class Hero {
    private final String nama;
    private final String role;
    private final String foto;

    public Hero(String nama, String role, String foto) {
        this.nama = nama;
        this.role = role;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public String getRole() {
        return role;
    }

    public String getFoto() {
        return foto;
    }

}
