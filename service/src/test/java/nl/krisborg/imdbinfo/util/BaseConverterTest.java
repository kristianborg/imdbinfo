package nl.krisborg.imdbinfo.util;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.fail;

/**
 * User: Kris
 * Since: 8-4-12 15:43
 */
public abstract class BaseConverterTest {

    protected String getFileAsString(String fileName) {
        BufferedReader file = null;
        String result = "";
        try {
            file = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = file.readLine()) != null) {
                result += line;
            }
        } catch (Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        } finally {
            try {
                file.close();
            } catch (Exception e) {}
        }
        return result;
    }
}
