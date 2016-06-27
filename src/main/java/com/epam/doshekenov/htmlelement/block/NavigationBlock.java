package com.epam.doshekenov.htmlelement.block;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(className = "b-folders__i")
public class NavigationBlock extends HtmlElement {

    @FindBy(xpath = "//a[@class='b-folders__folder__link'][@href='#draft']")
    private Link draftsLink;

    @FindBy(xpath = "//a[@class='b-folders__folder__link'][@href='#sent']")
    private Link sentList;


    public void openDraftsList(WebDriverWait wait) {
        draftsLink.click();
    }

    public void openSentList() {
        sentList.click();
    }
}
