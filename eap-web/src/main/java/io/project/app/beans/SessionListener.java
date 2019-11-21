/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author armena
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated started");
        HttpSession session = se.getSession();
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        UserContext userContext = (UserContext) externalContext.getSessionMap().get("userContext");
        if (userContext != null) {
            System.out.println("SessionCreated, URA");
            userContext.sessionCreated();
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        UserContext userContext = (UserContext) externalContext.getSessionMap().get("userContext");
        if (userContext != null) {
            System.out.println("SessionDestroyed");
            userContext.sessionDestroyed();
        }

    }

}
