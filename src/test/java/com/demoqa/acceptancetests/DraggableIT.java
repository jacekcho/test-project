package com.demoqa.acceptancetests;

import com.demoqa.category.TestCategory;
import com.demoqa.pages.DemoqaMainPage;
import com.demoqa.pages.DraggablePage;
import com.demoqa.utils.DriverFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@Category(TestCategory.class)
public class DraggableIT extends DriverFactory {


    private DemoqaMainPage demoqaMainPage;

    private DraggablePage draggablePage;

    private final String LEFT_POSITION = "left: %spx";

    private final String TOP_POSITION = "top: %spx";

    @Before
    public void executeBeforeTest() {
        demoqaMainPage = new DemoqaMainPage();
        draggablePage = new DraggablePage();
    }

    @Test
    public void shouldDraggable() {

        //given
        int newLeftPosition = 130;
        int newTopPosition = 180;
        demoqaMainPage.get();

        //when
        demoqaMainPage.goToDraggablePage().moveButtonToNewPosition(newLeftPosition, newTopPosition);

        //then
        assertThat(draggablePage.getNewElementPosition(), containsString(String.format(LEFT_POSITION, newLeftPosition)));
        assertThat(draggablePage.getNewElementPosition(), containsString(String.format(TOP_POSITION, newTopPosition)));

    }


}
