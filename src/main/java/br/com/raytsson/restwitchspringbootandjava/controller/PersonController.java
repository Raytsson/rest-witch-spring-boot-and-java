package br.com.raytsson.restwitchspringbootandjava.controller;

import br.com.raytsson.restwitchspringbootandjava.data.vo.v1.PersonVO;
import br.com.raytsson.restwitchspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.raytsson.restwitchspringbootandjava.model.Person;
import br.com.raytsson.restwitchspringbootandjava.services.PersonServices;
import br.com.raytsson.restwitchspringbootandjava.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML})
    public List<PersonVO> findAll() {
        return service.findAll();
    }
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML})
    public PersonVO findById(@PathVariable( value = "id") Long id)  throws Exception{

        return service.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML},produces = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML})
    public PersonVO create(@RequestBody Person person){
        return service.create(person);
    }

    @PostMapping(value = "/v2",consumes = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML},produces = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML})
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
        return service.createv2(person);
    }


    @PutMapping(consumes = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML},produces = {MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
            , MediaType.APPLICATION_YML})
    public PersonVO update(@RequestBody PersonVO person){

        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable( value = "id") Long id)  {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
