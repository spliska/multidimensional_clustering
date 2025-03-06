package backend.api.controllers;

import backend.db.MobileDeviceService;
import backend.db.PersonService;
import backend.models.MobileDevice;
import backend.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.Optional;

public class MobileDeviceController {

    Logger logger = LoggerFactory.getLogger(MobileDeviceController.class);
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(path="mobile-device-by-person-id",method = RequestMethod.GET)
    public ResponseEntity<MobileDevice> getMobileDeviceByPersonId(@RequestParam String id){
        logger.info("Processed api request for mobile device by person id");
        Optional<MobileDevice> mobileDevice= null;
        try {
            mobileDevice = Optional.of(new MobileDeviceService().getMobileDeviceByPersonId(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<MobileDevice> (mobileDevice.get(), HttpStatusCode.valueOf(200));
    }

    @RequestMapping(path="mobile-device-by-iccd",method = RequestMethod.GET)
    public ResponseEntity<MobileDevice> getMobileDeviceByIccd(@RequestParam String id){
        logger.info("Processed api request for mobile device by person id");
        Optional<MobileDevice> mobileDevice= null;
        try {
            mobileDevice = Optional.of(new MobileDeviceService().getMobileDeviceByIccd(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<MobileDevice> (mobileDevice.get(), HttpStatusCode.valueOf(200));
    }

}
