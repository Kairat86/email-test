package com.epam.doshekenov.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPathWaitObserver implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(XPathWaitObserver.class.getSimpleName());
    private Subject subject;
    private long currentWaitTime;
    private static final String XPATH = "xpath";

    public XPathWaitObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        String locatorName = subject.getLocatorName();
        long waitTime = subject.getWaitTime();
        if (locatorName == null || locatorName.equals(XPATH) && waitTime > currentWaitTime) {
            logger.info("Registered new wait time record: " + (currentWaitTime = waitTime) + "");
        }
    }
}