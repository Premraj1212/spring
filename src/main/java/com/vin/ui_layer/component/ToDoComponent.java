package com.vin.ui_layer.component;

import com.vin.annotation.PageFragment;
import com.vin.ui_layer.base.Base;
import com.vin.ui_layer.pages.ToDoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.stream.Collectors;

@PageFragment
public class ToDoComponent extends Base {
    private static final Logger logger = LoggerFactory.getLogger(ToDoComponent.class);

    @Value("${application.title}")
    private String pageTitle;

    @FindBy(className = "new-todo")
    private WebElement newToDoField;

    @FindBy(css = "div[class='view'] label")
    private List<WebElement> toDoListOfItems;

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.driver.getTitle().startsWith(pageTitle));
    }

    public List<String> getToDoListOfItem(){
        return toDoListOfItems
                .stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

    public void addItems(String task) {
        logger.info("Adding item :: ", task);
        //this.wait.until(ExpectedConditions.presenceOfElementLocated())
        newToDoField.sendKeys(task);
        newToDoField.sendKeys(Keys.ENTER);
    }
}
