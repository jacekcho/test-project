package com.demoqa.acceptancetests;

import com.demoqa.category.TestCategory;
import com.demoqa.driver.DriverFactory;
import com.demoqa.pages.demoqa.DemoqaMainPage;
import com.demoqa.pages.demoqa.DraggablePage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@Category(TestCategory.class)
public class DraggableIT extends DriverFactory {

    private final String LEFT_POSITION = "left: %spx";

    private final String TOP_POSITION = "top: %spx";

    @Test
    public void shouldDraggable() {
        // given
        int newLeftPosition = 130;
        int newTopPosition = 180;
        DraggablePage draggablePage = new DemoqaMainPage().get().goToDraggablePage();

        // when
        draggablePage.moveButtonToNewPosition(newLeftPosition, newTopPosition);

        // then
        assertThat(draggablePage.getNewElementPosition(), containsString(String.format(LEFT_POSITION, newLeftPosition)));
        assertThat(draggablePage.getNewElementPosition(), containsString(String.format(TOP_POSITION, newTopPosition)));

    }


}
