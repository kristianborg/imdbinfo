package nl.krisborg.imdbinfo.services;

/**
 * User: Kris
 * Since: 7-4-12 20:05
 */
public interface CrawlService {

    public void crawlUrl(String url, int crawlDepth);

}
