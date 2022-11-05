package edu.miu.cs545.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDtoV2 {
    private String title;
    private String content;
    private String author;
}
