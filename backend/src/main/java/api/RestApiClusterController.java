package api;

import models.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.db.GraphService;

import java.util.Optional;
@RestController
public class RestApiClusterController {

        Logger logger = LoggerFactory.getLogger(RestApiClusterController.class);
        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping(path="graph",method = RequestMethod.GET)
        public ResponseEntity<Graph> get(){
            logger.info("Processed api request for Donut Chart");
            Optional<Graph> graph= Optional.of(new GraphService().getGraph());
            return new ResponseEntity<Graph>(graph.get(), HttpStatusCode.valueOf(200));
        }
}
