package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CombinedEventLogger implements EventLogger {
    Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event){
        for (EventLogger eventLogger: loggers) {
            eventLogger.logEvent(event);
        }
    }
}
