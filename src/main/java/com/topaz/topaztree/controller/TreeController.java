package com.topaz.topaztree.controller;

import com.topaz.topaztree.api.request.Element;
import com.topaz.topaztree.service.Service;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Getter
public class TreeController {

    private final Service service;

    @Autowired
    public TreeController(Service service) {
        this.service = service;
    }

    @PostMapping("/tree")
    public int addTree(@RequestBody Element element) {
        service.setTime(LocalDateTime.now());
        service.setElement(element);
        return service.calculateTreeWeight();
    }
}
