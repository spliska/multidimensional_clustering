package services;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import controllers.PersonController;
import models.MobileDevice;
import models.Person;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PersonService {
    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(path="person",method = RequestMethod.GET)
    public Person get() {
        return new Person("12345", "Test", new MobileDevice("1234", "Smartphone", "1234"));
    }
}
