/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.trescom.poc.controllers;

import br.trescom.poc.daos.CityRepository;
import br.trescom.poc.models.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author as
 */
@Controller
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<City> getAllCitys() {
        return (List) cityRepository.findAllByOrderByIdDesc();
    }

    @RequestMapping(value = "/paginator", method = RequestMethod.GET)
    public @ResponseBody
    List<City> getAllCitysPaginator(
            @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return (List) cityRepository.findAll(new PageRequest(offset, limit));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody City getCitysById(@PathVariable("id") Long id) {
        return cityRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public @ResponseBody void deleteCitysById(@PathVariable("id") Long id) {
        cityRepository.delete(id);
    }
    
}
