/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author armena
 */

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        FacesContext context = FacesUtil.getFacesContext(HttpJSFUtil.getRequest(), HttpJSFUtil.getResponse());
        UserContext userContext = context.getApplication().evaluateExpressionGet(
                context, "#{userContext}", UserContext.class);

        System.out.println("LISTENER: SessionCreated started");

        if (userContext != null) {
            System.out.println("LISTENER SessionCreated, URA");
            userContext.sessionCreated();
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        FacesContext context = FacesUtil.getFacesContext(HttpJSFUtil.getRequest(), HttpJSFUtil.getResponse());
        UserContext userContext = context.getApplication().evaluateExpressionGet(
                context, "#{userContext}", UserContext.class);

        if (userContext != null) {
            System.out.println("LISTENER SessionDestroyed???");
            userContext.sessionDestroyed();
        }

    }

}
