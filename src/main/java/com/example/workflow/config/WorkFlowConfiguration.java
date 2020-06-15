package com.example.workflow.config;

import com.example.workflow.listener.WorkflowEngineEvent;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WorkFlowConfiguration implements ProcessEngineConfigurationConfigurer {
    @Resource
    WorkflowEngineEvent eventListener;
    @Override
    public void configure(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        List listeners = new ArrayList<>();
        listeners.add(eventListener);
        springProcessEngineConfiguration.setEventListeners(listeners);
    }

}
