package com.example.workflow.listener;

import org.springframework.stereotype.Component;

import static org.activiti.engine.delegate.event.ActivitiEventType.PROCESS_STARTED;

@Component
public class CreateProcessInstanceListener implements baselistener {
    @Override
    public Boolean support(String o) {
        return PROCESS_STARTED.name().equals(o);
    }

    @Override
    public void doTask(Object object) {
        System.out.println("发起了一个流程");
    }
}
