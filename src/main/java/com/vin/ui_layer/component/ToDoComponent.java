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

import static java.lang.String.format;

@PageFragment
public class ToDoComponent extends Base {
    private static final Logger logger = LoggerFactory.getLogger(ToDoComponent.class);

    @Value("${application.title}")
    private String pageTitle;

    @FindBy(className = "new-todo")
    private WebElement newToDoField;

    @FindBy(css = "div[class='view'] label")
    private List<WebElement> toDoListOfItems;

    private String complete_item = "//label[.='%s']/preceding-sibling::input[@type='checkbox']";
    private String select_status = "//ul[@class='filters']//a[.='%s']";
    private String select_task = "//label[.='%s']";
    private String delete_task = "//label[.='%s']/following-sibling::button";

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
        newToDoField.sendKeys(task);
        newToDoField.sendKeys(Keys.ENTER);
    }

    public void makeTaskAsComplete(String task) {
        By completeItemChk = By.xpath(format(complete_item, task));
        this.driver.findElement(completeItemChk).click();
    }

    public void selectStatus(String status) {
        By selectToDoStatus = By.xpath((format(select_status,status)));
        this.driver.findElement(selectToDoStatus).click();
    }

    public void selectTask(String task) {
        By selectTodoTask = By.xpath((format(select_task,task)));
        this.driver.findElement(selectTodoTask).click();
    }

    public void deleteTask(String task) {
        By deleteTodoTask = By.xpath((format(delete_task,task)));
        this.driver.findElement(deleteTodoTask).click();
    }
}
