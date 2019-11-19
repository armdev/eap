/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import io.project.app.entities.Account;
import io.project.app.facades.UserContextHolder;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.Asynchronous;
import javax.ejb.Schedule;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author armena
 */
@Named
@ViewScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = -2376710021307764001L;

    @Inject
    private UserContext userContext;

    @Inject
    private LoginRestClient loginRestClient;
    
    @Inject
    private FrontendValidator frontendValidator;
    
    

    private String email;
    private String password;

    public String doLogin() {
        Account doLoginWithAuthMicroservice = loginRestClient.doLoginWithAuthMicroservice(email, password);
        //check success, error....
        userContext.setAccount(doLoginWithAuthMicroservice);

        userContext.getContextHolder().getAccounts().put(doLoginWithAuthMicroservice.getId(), doLoginWithAuthMicroservice);
        frontendValidator.init();
        return "profile";
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

}
