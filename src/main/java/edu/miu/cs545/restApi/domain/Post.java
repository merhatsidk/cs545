package edu.miu.cs545.restApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id @GeneratedValue
    private long id;
    private String title;
    private String content;
    private String author;

    @OneToMany(cascade = CascadeType.ALL) @JoinColumn
    private List<Comment> comments;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
