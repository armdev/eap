/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author armena
 */
@Named
@RequestScoped
public class FrontendValidator implements Serializable {

    private static final long serialVersionUID = -5979092826854827939L;

    @Inject
    private UserContext userContext;

    @PostConstruct
    public void init() {
        System.out.println(" i am init ");
    }

    public void sendIdToBackendLogic() throws InterruptedException {

        System.out.println("Logged user: FE " + userContext.getAccount().getEmail());

    }

}
