package com.example.workflow.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.util.json.JSONObject;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("flow")
public class WorkflowController {
    @Resource
    RepositoryService repositoryService;
    @Resource
    RuntimeService runtimeService;
    @PostMapping("publish")
    public String publishFlow(@RequestParam("file") MultipartFile myfiles){

        Deployment deployment = null;
        try {
            InputStream inputStream = myfiles.getInputStream();
            deployment = repositoryService.createDeployment().addInputStream("测试流程.bpmn",inputStream).deploy();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
    @PostMapping("start")
    public String startFlow(@RequestParam String Id){

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(Id);


        return "success";
    }
}
