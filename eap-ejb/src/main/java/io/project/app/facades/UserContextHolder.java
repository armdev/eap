/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.facades;

import io.project.app.entities.Account;
import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author armena
 */
@ApplicationScoped
@Named
public class UserContextHolder implements Serializable {

    private static final long serialVersionUID = 6680800607179243715L;

    private HashMap<Long, Account> accounts
            = new HashMap<>();

    public HashMap<Long, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<Long, Account> accounts) {
        this.accounts = accounts;
    }

   
}
