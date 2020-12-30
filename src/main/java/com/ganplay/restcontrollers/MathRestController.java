package com.ganplay.restcontrollers;

import com.ganplay.controllers.MathDataService;
import com.ganplay.models.math.MathInputData;
import com.ganplay.models.math.MathOutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathRestController {

    @Autowired
    private MathDataService mathService;

    @GetMapping("/math")
    public String helloMath()
    {
        return "Hello math !";
    }

    @CrossOrigin
    @PostMapping("receiveMathGame")
    public MathOutputData receiveMathGame(@RequestBody MathInputData mathInputData)
    {
        return mathService.receiveMathGame(mathInputData);
    }
}
