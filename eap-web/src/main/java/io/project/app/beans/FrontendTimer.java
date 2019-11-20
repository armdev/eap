/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import javax.ejb.Asynchronous;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author armena
 */
@Singleton
@Startup
public class FrontendTimer {

    @Inject
    private UserContext userContext;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    @Asynchronous
    public void atSchedule() throws InterruptedException {
        System.out.println("Get Logged user stored in the session each 5 seconds ");
        System.out.println("FR " + userContext.getAccount().toString());
    }

}
