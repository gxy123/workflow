package com.example.workflow.listener;

import org.springframework.stereotype.Component;

import static org.activiti.engine.delegate.event.ActivitiEventType.TASK_CREATED;

@Component
public class CreateTaskNodeListener implements baselistener {
    @Override
    public Boolean support(String o) {

        return TASK_CREATED.name().equals(o);
    }

    @Override
    public void doTask(Object object) {
        System.out.println("开启了一个任务节点");
    }
}
