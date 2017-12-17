package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

/**
 * Created by rusamaha on 12/16/17.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
