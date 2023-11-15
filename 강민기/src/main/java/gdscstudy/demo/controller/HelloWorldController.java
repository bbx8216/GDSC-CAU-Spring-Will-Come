package gdscstudy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/first") // localhost:8080/first
    @ResponseBody
    public String index(){
        return "hello world!";
    }
}