package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.beans.EventType;
import com.epam.spring.core.loggers.CacheFileEventLogger;
import com.epam.spring.core.loggers.ConsoleEventLogger;
import com.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class App {

    private Client client;
    private EventLogger eventLogger;
    private EventLogger defaultLogger;
    private Event event;
    private Map<EventType, EventLogger> loggers;

    public App() {
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers, Event event) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.event= event;
        this.loggers = loggers;

    }

//    public void logEvent(String msg){
//        String message = msg.replaceAll(client.getId(), client.getFullName());
//        eventLogger.logEvent(message);
//    }

    public void logEvent(EventType type, String msg){
//        String message = event.replaceAll(client.getId(), client.getFullName());
        event.setMsg(msg);
        EventLogger logger = loggers.get(type);
        if(logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);


//        eventLogger.logEvent(event);
    }

    public void setDefaultLogger(EventLogger logger){
        this.defaultLogger = logger;
    }
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");


        App app = (App) ctx.getBean("app");

//        app.logEvent("Some event for user 2");
//        app.logEvent("Some event for user 1");
        app.logEvent(EventType.ERROR,  "Some event for user 2");
        app.logEvent(EventType.INFO, "Some event for user 1");
        app.logEvent(null, "Some event for user 1");
        ctx.close();
    }

}
