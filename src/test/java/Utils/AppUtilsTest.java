package Utils;

import org.junit.Test;
import uk.ac.city.cc.utils.AppUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by santiagoginzburg on 04/04/2017.
 */
public class AppUtilsTest {

    @Test
    public void testReadFile() throws IOException {
        String[] results =  AppUtils.readFile(
                new File(System.getProperty("user.home") + File.separator + "./.aws/credentials"));
        assertTrue(results != null);
        assertTrue(results.length == 2);
        assertTrue(results[0] != null && results[1] != null);
        assertTrue(results[0].length()>0 && results[1].length()>0);
    }
}
