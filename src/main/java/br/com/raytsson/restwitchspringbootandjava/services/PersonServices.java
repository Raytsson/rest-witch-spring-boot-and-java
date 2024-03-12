package br.com.raytsson.restwitchspringbootandjava.services;

import br.com.raytsson.restwitchspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Buscando todas as pessoas");

        List<Person> persons = new ArrayList<>();
        for (int i =0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    public Person findById(String id){

        logger.info("Buscando uma pessoa");

        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlandia - minas gerais - Brazil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){

        logger.info("Criando uma pessoa");

        return person;
    }

    public Person update(Person person){

        logger.info("Atualizando uma pessoa");

        return person;
    }
    public void delete(String id){

        logger.info("Deletando uma pessoa");
    }


    //moque estrutura de codigo temporaria que sustenta o codigo antes de estar pronto e assim vai se removendo até estar totalmente pronto.
    private Person mockPerson(int i) {
        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil" + i);
        person.setGender("Male");
        return person;
    }

}
