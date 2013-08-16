package nl.krisborg.imdbinfo.dto;

import org.hibernate.annotations.CollectionOfElements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String name = "";

    private String url;

    private boolean crawled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="MOVIE_ACTORS", joinColumns=@JoinColumn(name="MOVIE_ID"))
    @Column(name="URL")
    private Set<String> actors = new HashSet<String>();

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCrawled() {
        return crawled;
    }

    public void setCrawled(boolean crawled) {
        this.crawled = crawled;
    }

    public Set<String> getActors() {
        return actors;
    }

    public void setActors(Set<String> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Movie)){
            return false;
        } else {
            return ((Movie)o).getUrl().equals(url);
        }
    }

    @Override
    public String toString(){
        return "[name=" + name + ", url=" + url + ", actors=" + actors.size() + "]";
    }
}
