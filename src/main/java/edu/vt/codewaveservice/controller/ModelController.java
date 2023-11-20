package edu.vt.codewaveservice.controller;

import edu.vt.codewaveservice.common.BaseResponse;
import edu.vt.codewaveservice.common.ResultUtils;
import edu.vt.codewaveservice.manager.TTSModels.TTSModelProperties;
import edu.vt.codewaveservice.mq.TestPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/model")
public class ModelController {


    @Autowired
    private  TTSModelProperties ttsModelProperties;

    @Autowired
    private TestPublisher testPublisher;


    @GetMapping("/list")
    public BaseResponse list() {
//        System.out.printf("ttsModelProperties.getModels().keySet() = %s\n", ttsModelProperties.getModels().keySet());
        return ResultUtils.success(ttsModelProperties.getModels().keySet());
    }

    @GetMapping("/test")
    public void test() {
        testPublisher.publishTestMessage("Hello, Redis!");

    }
}
