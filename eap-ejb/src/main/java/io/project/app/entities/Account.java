/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.entities;

/**
 *
 * @author armena
 */
public class Account {

    private Long id;

    public Account(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account() {
    }

    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }

}
