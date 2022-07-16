package com.vin.ui_layer.pages;

import com.vin.annotation.Page;
import com.vin.ui_layer.base.Base;
import com.vin.ui_layer.component.ToDoComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
}
