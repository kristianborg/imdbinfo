package nl.krisborg.imdbinfo.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Kris
 * @since 14-feb-2010
 */
public class ImdbSiteDaoImpl implements ImdbSiteDao {

    private static final Log LOG = LogFactory.getLog(ImdbSiteDao.class);
    
    public String getHtmlFile(String remoteUrl){
        BufferedReader in = null;
        String result = "";

        try {
            LOG.info("Downloading: " + remoteUrl);
            URL url = new URL(remoteUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.addRequestProperty("host", "www.imdb.com");
            urlConnection.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6 (.NET CLR 3.5.30729)");

            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result += line + "\r\n";
            }
        } catch (Exception e){

        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        return result;
    }
}
