package com.vaibhav.spring.cloud.gitconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Value("${message.greeting}") private String value;
    
    @Autowired
    private Environment environment;
    
    
    @RequestMapping(value = "/property/{prop}", method = RequestMethod.GET)
    public String getProperty(@PathVariable String prop) {
        return environment.getProperty(prop);
    }
    
    @RequestMapping(value = "/value", method = RequestMethod.GET)
    public String getValue() {
        return value;
    }
}