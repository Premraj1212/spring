package com.vin.ui_layer.component;

import com.vin.annotation.PageFragment;
import com.vin.ui_layer.base.Base;
import com.vin.ui_layer.pages.ToDoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

@PageFragment
public class ToDoComponent extends Base {
    private static final Logger logger = LoggerFactory.getLogger(ToDoComponent.class);

    @Value("${application.title}")
    private String pageTitle;

    @FindBy(className = ".new-todo")
    private WebElement newToDoField;

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.driver.getTitle().startsWith(pageTitle));
    }
}
