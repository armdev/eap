/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.facades;

import io.project.app.entities.Account;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
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
public class UserContextScheduler implements Serializable {

    private static final long serialVersionUID = -1635435233255536130L;

    @Inject
    private UserContextHolder contextHolder;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    @Asynchronous
    public void atSchedule() throws InterruptedException {

        Iterator hmIterator = contextHolder.getAccounts().entrySet().iterator();

        for (Map.Entry<Long, Account> entry : contextHolder.getAccounts().entrySet()) {
            System.out.println("Logged users: In atSchedule() " + entry.getKey() + " = " + entry.getValue().toString());
        }

    }
}
