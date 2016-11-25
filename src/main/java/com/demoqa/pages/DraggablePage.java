package com.demoqa.pages;

import com.demoqa.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraggablePage {

    @FindBy(id = "draggable")
    private WebElement buttonToDrag;

    private Actions builder;

    public DraggablePage() {
        builder = new Actions(DriverFactory.driver);
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public DraggablePage moveButtonToNewPosition(int left, int top) {
        Action dragAndDrop = builder.clickAndHold(buttonToDrag).moveByOffset(left, top).release().build();
        dragAndDrop.perform();
        return this;
    }

    public String getNewElementPosition() {
        return buttonToDrag.getAttribute("style");
    }

}
