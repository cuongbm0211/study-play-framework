package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by cuongbui on 5/23/17.
 */

@Entity
public class Post extends Model{

    public String title;
    public Date postedAt;

    @Lob
    public String content;

    @ManyToOne
    public User author;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    public List<Comment> comments;

    public Post(User author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }
}
