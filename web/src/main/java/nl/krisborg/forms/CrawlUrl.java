package nl.krisborg.forms;

/**
 * User: Kris
 * Since: 7-4-12 19:46
 */
public class CrawlUrl {

    private String imdbUrl;
    private int crawlDepth;

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    public int getCrawlDepth() {
        return crawlDepth;
    }

    public void setCrawlDepth(int crawlDepth) {
        this.crawlDepth = crawlDepth;
    }
}
