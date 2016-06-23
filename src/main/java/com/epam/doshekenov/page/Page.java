package com.epam.doshekenov.page;

import com.epam.doshekenov.observer.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {

    protected final WebDriver driver;
    protected Subject subject;

    protected WebDriverWait wait;

    protected Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 6);
        subject = new Subject();
        new IdWaitObserver(subject);
        new XPathWaitObserver(subject);
        new ClassNameWaitObserver(subject);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
