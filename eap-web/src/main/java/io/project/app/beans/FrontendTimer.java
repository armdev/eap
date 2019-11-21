/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans;

import io.project.app.entities.Account;
import java.util.ArrayList;
import java.util.List;
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

    private List<Account> currentSessions = new ArrayList<>();

    @Inject
    private UserContext userContext;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    @Asynchronous
    public void atSchedule() throws InterruptedException {
        System.out.println("FRONTEND: Get Logged user stored in the session each 5 seconds ");       

        for (Account ac : currentSessions) {
            System.out.println("FRONTEND: Sending active users to backend " + ac.getEmail());
            userContext.getContextHolder().addOrUpdateAccount(ac.getId(), ac);
        }

    }

    public void add(Account account) {
        System.out.println("FRONTEND: Ooo, account added");
        currentSessions.add(account);
    }

    public void remove(Account account) {
          System.out.println("FRONTEND: Ooo, account removed");
        currentSessions.remove(account);
    }

}
