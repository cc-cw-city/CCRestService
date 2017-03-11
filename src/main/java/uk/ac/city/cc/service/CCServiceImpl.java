package uk.ac.city.cc.service;

import uk.ac.city.cc.dto.ServiceResponse;
import org.springframework.stereotype.Service;

/**
 * Created by santiagoginzburg on 11/03/2017.
 */
@Service
public class CCServiceImpl implements CCService {
    @Override
    public ServiceResponse processService() {
        return new ServiceResponse("test message");
    }
}
