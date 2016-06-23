package com.epam.doshekenov.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassNameWaitObserver implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(ClassNameWaitObserver.class.getSimpleName());
    private Subject subject;
    private long currentWaitTime;
    private static final String CLASSNAME = "classname";

    public ClassNameWaitObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        if (subject.getLocatorName().equals(CLASSNAME) && subject.getWaitTime() > currentWaitTime) {
            logger.info("Registered new wait time record: " + (currentWaitTime = subject.getWaitTime()) + "");
        }
    }
}
