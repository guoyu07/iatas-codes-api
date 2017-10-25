package com.github.pablocloud.iataapi.controllers;

import com.github.pablocloud.iataapi.domain.Iata;
import com.github.pablocloud.iataapi.services.IataService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/iata", "/iata/"})
public class IataController {

    private final IataService iataService;

    public IataController(IataService iataService) {
        this.iataService = iataService;
    }

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Iata> all() {
        return iataService.all();
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Iata one(@PathVariable Long id) {
        return iataService.oneById(id);
    }

    @RequestMapping(value = {"/name/{name}"}, method = RequestMethod.GET)
    public List<Iata> byName(@PathVariable String name) {
        return iataService.byName(name);
    }

    @RequestMapping(value = {"/code/{code}"}, method = RequestMethod.GET)
    public List<Iata> byCode(@PathVariable String code) {
        return iataService.byCode(code);
    }

}
