/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.trescom.poc.controllers;

import br.trescom.poc.models.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import br.trescom.poc.daos.StateRepository;

/**
 *
 * @author as
 */
@Controller
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateRepository statesRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<State> getAllStates() {
        return (List) statesRepository.findAllByOrderByIdDesc();
    }

    @RequestMapping(value = "/paginator", method = RequestMethod.GET)
    public @ResponseBody
    List<State> getAllStatesPaginator(
            @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return (List) statesRepository.findAll(new PageRequest(offset, limit));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    State getStatesById(@PathVariable("id") Long id) {
        return statesRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public @ResponseBody void deleteStatesById(@PathVariable("id") Long id) {
        statesRepository.delete(id);
    }

}
