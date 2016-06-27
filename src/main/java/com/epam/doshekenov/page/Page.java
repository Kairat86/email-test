package com.epam.doshekenov.page;

import com.epam.doshekenov.observer.*;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public abstract class Page extends PageObject {

    public static final String INBOX = "#inbox";
    protected Subject subject;

    protected Page() {
        subject = new Subject();
        new IdWaitObserver(subject);
        new XPathWaitObserver(subject);
        new ClassNameWaitObserver(subject);
        new TimeOutObserver(subject);
    }

    public Boolean isElementPresent(By locator) {
        return getDriver().findElements(locator).size() > 0;
    }

    public void checkURL() {
        getDriver().getCurrentUrl().contains(INBOX);
    }
}
