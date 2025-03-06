package backend.api.controllers;

import backend.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.db.PersonService;

import java.util.Optional;

@RestController
public class PersonController {

        Logger logger = LoggerFactory.getLogger(PersonController.class);
        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping(path="persons",method = RequestMethod.GET)
        public ResponseEntity<Person[]> getPersons(){
            logger.info("Processed api request for all persons");
            Optional<Person[]> persons= Optional.of(new PersonService().getAllPersons());
            return new ResponseEntity<Person[]>(persons.get(), HttpStatusCode.valueOf(200));
        }

    @RequestMapping(path="personsbyid",method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonByName(@RequestParam String id){
        logger.info("Processed api request for person by id");
        Optional<Person> person= Optional.of(new PersonService().getPersonById(id));
        return new ResponseEntity<Person> (person.get(), HttpStatusCode.valueOf(200));
    }



}

