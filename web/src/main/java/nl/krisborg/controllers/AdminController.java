package nl.krisborg.controllers;

import nl.krisborg.imdbinfo.services.ActorService;
import nl.krisborg.imdbinfo.services.CrawlService;
import nl.krisborg.forms.CrawlUrl;
import nl.krisborg.imdbinfo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: Kris
 * Since: 7-4-12 17:05
 */
@Controller
public class AdminController {

    @Autowired
    ActorService actorService;

    @Autowired
    MovieService movieService;

    @Autowired
    CrawlService crawlService;

    @RequestMapping(method = RequestMethod.GET, value = "/actors")
    protected ModelAndView listActors() throws Exception {
        ModelAndView result = new ModelAndView("admin/main");
        result.addObject("pageName", "actors");
        result.addObject("actors", actorService.getActors());
        return result;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/add")
    protected ModelAndView onGet() throws Exception {
        ModelAndView result = new ModelAndView("admin/main");
        result.addObject("pageName", "add");
        result.addObject("numMovies", movieService.getNumMovies());
        result.addObject("numActors", actorService.getNumActors());
        result.addObject("crawlUrl", new CrawlUrl());
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    protected ModelAndView onSubmit(CrawlUrl crawlUrl) throws Exception {
        crawlService.crawlUrl(crawlUrl.getImdbUrl(), crawlUrl.getCrawlDepth());
        return onGet();
    }
}
