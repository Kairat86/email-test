package com.epam.doshekenov.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeOutObserver implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(TimeOutObserver.class.getSimpleName());
    private Subject subject;
    private long currentWaitTime;
    private static final String XPATH = "xpath";

    public TimeOutObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        if (subject.getLocatorName() == null) {
            logger.info("Registered time out! ");
        }
    }
}
