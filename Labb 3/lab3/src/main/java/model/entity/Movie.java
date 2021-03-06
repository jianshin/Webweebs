package model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie implements Serializable {
    @Id @NonNull private String title;

    @NonNull private String avg_rating;
    @NonNull private String overview;
    @NonNull private String release_date;
    @NonNull private String poster_path;
    @NonNull private String id;
    @ElementCollection @NonNull private List<String> genres;
    
    @JoinTable(name = "actor_list",
            joinColumns = @JoinColumn(name = "movie"),
            inverseJoinColumns = @JoinColumn(name = "actor"))
    @ManyToMany private List<Actor> actors;
        
    @OneToMany(mappedBy = "movieReviewed")
    private List<Review> reviews;
    
}