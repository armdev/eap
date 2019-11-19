/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import io.project.app.entities.Account;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author armena
 */
@Named
@ApplicationScoped
public class LoginRestClient implements Serializable{
    
    private static final long serialVersionUID = -2975490860122358829L;
    
    
    public Account doLoginWithAuthMicroservice(String email, String password){
        System.out.println("Login always success");
        return new Account(System.currentTimeMillis(), email, password);
    }
    
    
}
