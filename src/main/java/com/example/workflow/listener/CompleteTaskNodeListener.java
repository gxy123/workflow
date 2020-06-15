package com.example.workflow.listener;

import org.springframework.stereotype.Component;

import static org.activiti.engine.delegate.event.ActivitiEventType.TASK_COMPLETED;


@Component
public class CompleteTaskNodeListener implements baselistener {
    @Override
    public Boolean support(String o) {

        return TASK_COMPLETED.name().equals(o);
    }

    @Override
    public void doTask(Object object) {
        System.out.println("发布了一个流程");
    }
}
