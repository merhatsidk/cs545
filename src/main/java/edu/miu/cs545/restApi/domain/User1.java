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
public class User1 {
        @Id
        @GeneratedValue
        Long id;
        String name;
        @OneToMany
                @JoinColumn
        List<Post> posts;

        public User1(String name) {
                this.name = name;
        }
}
