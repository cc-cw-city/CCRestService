package uk.ac.city.cc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by santiagoginzburg on 04/04/2017.
 */
public class AppUtils {

    /**
     aws_access_key_id = AKIAIYAAI643AKFGSUFA
     aws_secret_access_key = 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
     * */

    public static final String ACCESS_KEY = "aws_access_key_id";
    public static final String SECRET_KEY = "aws_secret_access_key";
    public static final char EQUAL = '=';

    public static String[] readFile(File fin) throws IOException {

        String[] keys = new String[2];

        // Construct BufferedReader from FileReader
        BufferedReader br = new BufferedReader(new FileReader(fin));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.trim().contains(ACCESS_KEY)) {
                keys[0] = line.substring(line.indexOf(EQUAL) + 1).trim();
            }

            if (line.trim().contains(SECRET_KEY)) {
                keys[1] = line.substring(line.indexOf(EQUAL) + 1).trim();
            }
        }

        br.close();

        return keys;
    }
}
