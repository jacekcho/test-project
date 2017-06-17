package com.demoqa.pages.demoqa;

import com.demoqa.utils.PageAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoqa.driver.SeleniumTestBase.driver;

public class DraggablePage {

    @FindBy(id = "draggable")
    private WebElement buttonToDrag;

    private Actions builder;

    private PageAction action;

    public DraggablePage() {
        builder = new Actions(driver);
        action = new PageAction();
        PageFactory.initElements(driver, this);
    }

    public DraggablePage moveRectangleToNewPosition(int left, int top) {
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
