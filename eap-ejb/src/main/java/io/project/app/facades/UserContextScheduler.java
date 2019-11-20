/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.facades;

import io.project.app.entities.Account;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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

    @Schedule(second = "*/60", minute = "*", hour = "*", persistent = false)
    @Asynchronous
    public void atSchedule() throws InterruptedException {

        Iterator hmIterator = contextHolder.getAccounts().entrySet().iterator();
        Date currentTime = new Date();
        for (Map.Entry<Long, Account> entry : contextHolder.getAccounts().entrySet()) {
            System.out.println("Logged users: In atSchedule() " + entry.getKey() + " = " + entry.getValue().toString());
            Account value = entry.getValue();

            long recordTime = value.getRecordDate().getTime();

            long current = currentTime.getTime();

            long result = current - recordTime;
            
            System.out.println(result);

            long toMinutes = TimeUnit.MILLISECONDS.toMinutes(result);
            if (toMinutes > 5) {
                System.out.println("Deleting from online users: ToMinutes " + toMinutes);

                contextHolder.getAccounts().remove(entry.getKey());
            }
        }

    }
}
