package uk.ac.city.cc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.city.cc.dto.ServiceResponse;
import uk.ac.city.cc.service.CCService;


/**
 * Created by santiagoginzburg on 11/03/2017.
 */
@RestController
public class CCResource {

    @Autowired
    private CCService ccService;

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public ResponseEntity<String> healthcheck() {
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/cc", method = RequestMethod.GET)
    public ServiceResponse getProcessResponse() {
        return ccService.processService();
    }
}
