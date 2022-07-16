package com.vin.ui_layer.pages;

import com.vin.annotation.Page;
import com.vin.data_models.TaskStatus;
import com.vin.helper.RunHelper;
import com.vin.ui_layer.base.Base;
import com.vin.ui_layer.component.ToDoComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Page
public class ToDoPage extends Base {
    private static final Logger logger = LoggerFactory.getLogger(ToDoPage.class);

    @Autowired
    ToDoComponent toDoComponent;

    @Value("${application.url}")
    private String url;


    public void goTo(){
        this.driver.get(url);
        logger.info("User launched application successfully");
    }


    @Override
    public boolean isAt() {
        return this.toDoComponent.isAt();
    }

    public boolean verifyToDoListIsEmpty() {
        return toDoComponent.getToDoListOfItem().isEmpty();
    }

    public void addToDoItemsInTheList(List<String> tasks) {
        tasks.forEach(
                task -> {
                    toDoComponent.addItems(task);
                }
        );
    }

    public List<String> getCurrentToDoTaskShownInTheList() {
        return toDoComponent.getToDoListOfItem();
    }

    public void completeItem(String task) {
        toDoComponent.makeTaskAsComplete(task);
    }

    public void selectTaskByStatus(String status) {
        toDoComponent.selectStatus(status);
    }


    public List<String> fetchActiveTask(List<TaskStatus> taskStatuses) {
        return taskStatuses
                .stream()
                .filter(task -> task.getActive() != null)
                .map(TaskStatus::getActive)
                .collect(Collectors.toList());
    }

    public List<String> fetchCompletedTask(List<TaskStatus> taskStatuses) {
        return taskStatuses
                .stream()
                .filter(task -> task.getCompleted() != null)
                .map(TaskStatus::getCompleted)
                .collect(Collectors.toList());
    }
    public List<String> fetchAllTask(List<TaskStatus> taskStatuses) {
        return taskStatuses
                .stream()
                .filter(task -> task.getAll() != null)
                .map(TaskStatus::getAll)
                .collect(Collectors.toList());
    }


}
