package br.com.raytsson.restwitchspringbootandjava.services;

import br.com.raytsson.restwitchspringbootandjava.data.vo.v1.PersonVO;
import br.com.raytsson.restwitchspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.raytsson.restwitchspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.raytsson.restwitchspringbootandjava.mapper.DozerMapper;
import br.com.raytsson.restwitchspringbootandjava.mapper.custom.PersonMapper;
import br.com.raytsson.restwitchspringbootandjava.model.Person;
import br.com.raytsson.restwitchspringbootandjava.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;


    public List<PersonVO> findAll(){
        logger.info("Buscando todas as pessoas");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;
    }


    public PersonVO findById(Long id){

        logger.info("Buscando uma pessoa");

        PersonVO person =  new PersonVO();

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(Person person){

        logger.info("Criando uma pessoa");

        var entity =  DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    //public PersonVOV2 createV2(PersonVOV2 person){
    public PersonVOV2 createv2(PersonVOV2 person) {

        logger.info("Criando uma pessoa V2");

        var entity =  mapper.convertVoTOEntity(person);
        var vo = mapper.convertEntityToVO(repository.save(entity));

        return vo;
    }

    public PersonVO update(PersonVO person){

        logger.info("Atualizando uma pessoa");


        var entity =  repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }
    public void delete(Long id){

        logger.info("Deletando uma pessoa");

        var entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
