package edu.miu.cs545.restApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostV2 {

        @Id @GeneratedValue
        long id;
        String title;
        String content;
        String author;
        String play;


}
