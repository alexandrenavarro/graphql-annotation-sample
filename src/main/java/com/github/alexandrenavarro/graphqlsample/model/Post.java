package com.github.alexandrenavarro.graphqlsample.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post implements PostInterface1, PostInterface2 {

    private Long id;
    private String text;
    private Comment comment;
}