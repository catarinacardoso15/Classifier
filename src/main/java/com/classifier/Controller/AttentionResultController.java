package com.classifier.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Catarina Cardoso on 02/06/2017.
 */

@RestController
public class AttentionResultController {
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(path = "/classifier", method = RequestMethod.GET)
    public String greeting() {
        return counter.incrementAndGet()+ " - Hello me";
    }
}
