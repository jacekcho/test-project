package com.demoqa.pages;

import com.demoqa.driver.DriverFactory;
import com.demoqa.utils.PageAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraggablePage {

    @FindBy(id = "draggable")
    private WebElement buttonToDrag;

    private Actions builder;

    private PageAction action;

    public DraggablePage() {
        builder = new Actions(DriverFactory.driver);
        action = new PageAction();
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public DraggablePage moveButtonToNewPosition(int left, int top) {
        builder.clickAndHold(buttonToDrag)
                .moveByOffset(left, top)
                .release()
                .build()
                .perform();
        return this;
    }

    public String getNewElementPosition() {
        return action.getElementAttribute(buttonToDrag, "style");
    }

}
