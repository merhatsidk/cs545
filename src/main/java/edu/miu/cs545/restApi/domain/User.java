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
@Table(name = "user_table")
public class User {
        @Id
        @GeneratedValue
        Long id;
        String name;
        @OneToMany(cascade = CascadeType.ALL)
                @JoinColumn
        List<Post> posts;

        public User(String name) {
                this.name = name;
        }
}
