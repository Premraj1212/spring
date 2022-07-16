package com.vin.stepdefs;

import com.vin.annotation.LazyAutowired;
import com.vin.ui_layer.pages.ToDoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.List;

@SpringBootTest
@CucumberContextConfiguration
public class AddTaskSteps {

    @LazyAutowired
    ToDoPage toDoPage;

    @Given("user has logged onto the application")
    public void userHasLoggedOntoTheApplication() {
        toDoPage.goTo();
        Assert.assertTrue(toDoPage.isAt());
    }

    @Given("user todo list is empty")
    public void userTodoListIsEmpty() {
    }

    @When("user adds following tasks:")
    public void userAddsFollowingTasks(List<String> tasks) {
    }

    @Then("user should see all task added to the application")
    public void userShouldSeeAllTaskAddedToTheApplication() {
    }
}
