package com.app.demoproject.controller;

import com.app.demoproject.model.BusOperator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Component("/busOperator")
public class BusOperatorController {
    @GetMapping("/add")
    public BusOperator addBusOperatorView() {
        return new BusOperator();
    }

    @PostMapping("/save")
    public boolean saveBusOperator(@ModelAttribute BusOperator busOperator) {
        return true;
    }
}
