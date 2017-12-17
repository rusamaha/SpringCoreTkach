package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusamaha on 12/17/17.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event){
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventFromCache();
            cache.clear();
        }
    }

    private void writeEventFromCache() {
        for(Event event: cache){
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()){
            writeEventFromCache();
        }
    }

}
