package com.example.workflow.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkflowEngineEvent implements ActivitiEventListener {
    @Lazy
    @Autowired
    List<baselistener> baselisteners;
    @Override
    public void onEvent(ActivitiEvent activitiEvent) {
        for (baselistener baselistener : baselisteners) {
            if(baselistener.support(activitiEvent.getType().name())){
                baselistener.doTask(activitiEvent);
            }
        }
    }

    //该isFailOnException()方法确定onEvent(..)方法在调度事件时抛出异常时的行为。

    // 当false返回，异常被忽略。当true返回，异常不会被忽略

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
