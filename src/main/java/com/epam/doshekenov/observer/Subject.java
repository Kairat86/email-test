package com.epam.doshekenov.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> list;
    private String locatorName;
    private long searchTime;


    public Subject() {
        this.list = new ArrayList<>();
    }

    public void setState(String locatorName, long searchTime) {
        this.locatorName = locatorName;
        this.searchTime = searchTime;
        notifyObservers();

    }

    public String getLocatorName() {
        return locatorName;
    }


    public long getWaitTime() {
        return searchTime;
    }


    public void attach(Observer observer) {
        list.add(observer);
    }

    public void notifyObservers() {
        list.forEach(observer -> observer.update());
    }

}
