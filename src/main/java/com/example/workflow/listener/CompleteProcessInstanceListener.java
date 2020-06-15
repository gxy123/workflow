package com.example.workflow.listener;

import org.springframework.stereotype.Component;

import static org.activiti.engine.delegate.event.ActivitiEventType.PROCESS_COMPLETED;

@Component
public class CompleteProcessInstanceListener implements baselistener {
    @Override
    public Boolean support(String o) {
        return PROCESS_COMPLETED.name().equals(o);
    }

    @Override
    public void doTask(Object object) {
        System.out.println("完成了一个流程实例");
    }
}
