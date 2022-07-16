package com.vin.stepdefs;


import com.vin.annotation.LazyAutowired;
import com.vin.data_models.TaskStatus;
import com.vin.ui_layer.pages.ToDoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TrackTaskSteps {

    @LazyAutowired
    ToDoPage toDoPage;

    @And("^user complete a task: (.*)$")
    public void userCompleteATaskFlyHigh(String task) {
        System.out.println(task);
        toDoPage.completeItem(task);
    }

    @DataTableType
    public TaskStatus taskStatuEntry(Map<String,String> entry){
        return new TaskStatus(
                entry.get("All"),
                entry.get("Completed"),
                entry.get("Active")
        );
    }


    @Then("^user should able to view the task by status:$")
    public void userShouldAbleToViewTheTaskByStatus(List<TaskStatus> taskStatuses) {
        toDoPage.selectTaskByStatus("Active");
        List<String> activeTask = toDoPage.fetchActiveTask(taskStatuses);
        Assert.assertEquals(toDoPage.getCurrentToDoTaskShownInTheList(), activeTask);

        toDoPage.selectTaskByStatus("Completed");
        List<String> completedTask = toDoPage.fetchCompletedTask(taskStatuses);
        Assert.assertEquals(toDoPage.getCurrentToDoTaskShownInTheList(), completedTask);

        toDoPage.selectTaskByStatus("All");
        List<String> allTask = toDoPage.fetchAllTask(taskStatuses);
        Assert.assertEquals(toDoPage.getCurrentToDoTaskShownInTheList(), allTask);

    }


}
