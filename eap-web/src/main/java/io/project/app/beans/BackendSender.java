/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import io.project.app.facades.UserContextHolder;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author armena
 */
@Named(value = "backendSender")
@RequestScoped
public class BackendSender implements Serializable {

    private static final long serialVersionUID = -6300995516234451200L;

    @Inject
    private UserContextHolder contextHolder;



    public UserContextHolder getContextHolder() {
        return contextHolder;
    }

    public void setContextHolder(UserContextHolder contextHolder) {
        this.contextHolder = contextHolder;
    }
}
