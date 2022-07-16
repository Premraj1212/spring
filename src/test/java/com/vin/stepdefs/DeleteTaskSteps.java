package com.vin.stepdefs;

import com.vin.annotation.LazyAutowired;
import com.vin.ui_layer.pages.ToDoPage;
import io.cucumber.java.en.And;

public class DeleteTaskSteps {

    @LazyAutowired
    ToDoPage toDoPage;

    @And("^user delete a task: (.*)$")
    public void userDeleteATaskFlyHigh(String task) {
        toDoPage.deleteToDoTask(task);
    }
}
