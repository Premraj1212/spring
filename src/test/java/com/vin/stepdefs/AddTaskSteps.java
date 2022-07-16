package com.vin.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@CucumberContextConfiguration
public class AddTaskSteps {

    @Given("user has logged onto the application")
    public void userHasLoggedOntoTheApplication() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/vue/");
        driver.quit();
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
