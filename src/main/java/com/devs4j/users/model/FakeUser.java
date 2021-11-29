package com.devs4j.users.model;

public class FakeUser {

    private String nikname;
    private String username;
    private String password;

    public FakeUser() {
    }

    public FakeUser(String nikname, String username, String password) {
        this.nikname = nikname;
        this.username = username;
        this.password = password;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
