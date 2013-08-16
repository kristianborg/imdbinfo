package nl.krisborg.imdbinfo.dto;

import org.hibernate.annotations.CollectionOfElements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ACTORS")
public class Actor {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String name;

    private String url;

    private boolean crawled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="ACTOR_MOVIES", joinColumns=@JoinColumn(name="ACTOR_ID"))
    @Column(name="URL")
    private Set<String> movies = new HashSet<String>();

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

    public Set<String> getMovies() {
        return movies;
    }

    public void setMovies(Set<String> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Actor)){
            return false;
        } else {
            return ((Actor)o).getUrl().equals(url);
        }
    }

    @Override
    public String toString(){
        return "[name=" + name + ", url=" + url + ", movies=" + movies.size() + "]";
    }
}
