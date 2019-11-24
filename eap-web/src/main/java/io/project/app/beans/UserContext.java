/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import io.project.app.entities.Account;
import io.project.app.facades.UserContextHolder;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author armena
 */
@Named(value = "userContext")
@SessionScoped
public class UserContext implements Serializable {

    private static final long serialVersionUID = -6300995516234451200L;

    @Inject
    private UserContextHolder contextHolder;

    @Inject
    private FrontendTimer frontendTimer;    

    private Account account = new Account();

    public void sessionCreated() {
        System.out.println("UserContext: Session Created");                
        frontendTimer.add(account);
    }

    public void sessionDestroyed() {
        System.out.println("UserContext: Session Destroyed");
        frontendTimer.remove(account);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public UserContextHolder getContextHolder() {
        return contextHolder;
    }

    public void setContextHolder(UserContextHolder contextHolder) {
        this.contextHolder = contextHolder;
    }
}
