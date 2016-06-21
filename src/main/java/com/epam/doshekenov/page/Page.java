package com.epam.doshekenov.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected final WebDriver driver;

    protected WebDriverWait wait;

    protected Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
