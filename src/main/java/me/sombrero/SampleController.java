package me.sombrero;

import me.sombrero.aop.LogExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @LogExecutionTime
    @GetMapping("/sample")
    public String sample() {
        return "Hello";
    }

}
