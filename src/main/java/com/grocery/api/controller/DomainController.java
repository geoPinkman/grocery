package com.grocery.api.controller;

import com.grocery.api.dom.Domain;
import com.grocery.api.service.DomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/domains")
public class DomainController {

    private final DomainService domainService;

    @PostMapping()
    public Domain createDomain(@RequestParam String domain) {
        Domain dom = new Domain();
        dom.setDomain(domain);
        return domainService.createDomain(dom);
    }
    @GetMapping("/")
    public List<Domain> getAll() {
        return domainService.getAllDomains();
    }

}
