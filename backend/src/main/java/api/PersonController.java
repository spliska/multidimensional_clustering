package api;

import models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.db.PersonService;

import java.util.Optional;

@RestController
public class PersonController {

        Logger logger = LoggerFactory.getLogger(PersonController.class);
        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping(path="persons",method = RequestMethod.GET)
        public ResponseEntity<Person[]> getPersons(){
            logger.info("Processed api request for Donut Chart");
            Optional<Person[]> persons= Optional.of(new PersonService().getAllPersons());
            return new ResponseEntity<Person[]>(persons.get(), HttpStatusCode.valueOf(200));
        }

    @RequestMapping(path="persons",method = RequestMethod.GET)
    public ResponseEntity<Person[]> getPersonByName(@RequestParam String id){
        logger.info("Processed api request for Donut Chart");
        Optional<Person[]> persons= Optional.of(new PersonService().getPersonById(id));
        return new ResponseEntity<Person[]>(persons.get(), HttpStatusCode.valueOf(200));
    }



}

