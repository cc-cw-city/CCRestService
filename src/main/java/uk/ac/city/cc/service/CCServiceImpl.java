package uk.ac.city.cc.service;

import com.amazonaws.util.EC2MetadataUtils;
import uk.ac.city.cc.dto.ServiceResponse;
import org.springframework.stereotype.Service;

/**
 * Created by santiagoginzburg on 11/03/2017.
 */
@Service
public class CCServiceImpl implements CCService {
    @Override
    public ServiceResponse processService() {
        String ec2Id = "No EC2 found";
        try {
            ec2Id = EC2MetadataUtils.getData("/latest/meta-data/public-ipv4");
        } catch (com.amazonaws.SdkClientException ex) {
            //do nothing
        }

        return new ServiceResponse("test message: " + ec2Id);
    }
}
