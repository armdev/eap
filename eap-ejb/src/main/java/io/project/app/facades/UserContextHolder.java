/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.facades;

import io.project.app.entities.Account;
import java.io.Serializable;
import java.util.Date;
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

    private final HashMap<Long, Account> accounts
            = new HashMap<>();

    public void addOrUpdateAccount(Long id, Account account) {

        Account get = this.getAccounts().get(id);

        if (get != null) {
            get.setRecordDate(new Date(System.currentTimeMillis()));
            this.getAccounts().replace(id, get);
        } else {
            account.setRecordDate(new Date(System.currentTimeMillis()));
            this.getAccounts().putIfAbsent(id, account);
        }
    }

    public void remove(Long id) {
        this.getAccounts().remove(id);
    }

    public HashMap<Long, Account> getAccounts() {
        return accounts;
    }

}
