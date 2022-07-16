package com.vin.stepdefs;

import com.vin.annotation.LazyAutowired;
import com.vin.helper.RunHelper;
import com.vin.ui_layer.pages.ToDoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.List;

@SpringBootTest
@CucumberContextConfiguration
public class AddTaskSteps {
    private static final Logger logger = LoggerFactory.getLogger(AddTaskSteps.class);

    @LazyAutowired
    ToDoPage toDoPage;

    @Given("user has logged onto the application")
    public void userHasLoggedOntoTheApplication() {
        toDoPage.goTo();
        Assert.assertTrue(toDoPage.isAt());
    }

    @Given("user todo list is empty")
    public void userTodoListIsEmpty() {
        Assert.assertTrue(toDoPage.verifyToDoListIsEmpty());
    }

    @When("^user adds following tasks:$")
    public void userAddsFollowingTasks(List<String> tasks) {
        toDoPage.addToDoItemsInTheList(tasks);
    }

    @Then("^user should see all task added to the application:$")
    public void userShouldSeeAllTaskAddedToTheApplication(List<String> addedTask) {
        logger.info("Actual Result added in APP"+toDoPage.getCurrentToDoTaskShownInTheList());
        logger.info("Expected Result passed to APP"+addedTask);
        Assert.assertEquals(toDoPage.getCurrentToDoTaskShownInTheList(),addedTask);
    }
}
