package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

/**
 * Created by rusamaha on 12/16/17.
 */

public interface EventLogger {
    void logEvent(Event event);
}
