package com.github.alexandrenavarro.graphqlsample.api;

import com.github.alexandrenavarro.graphqlsample.model.Comment;
import com.github.alexandrenavarro.graphqlsample.model.Post;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@GraphQLApi
public class Query {

    public List<Post> posts = List.of(
            Post.builder()
                    .id(1L)
                    .text("text " + 1)
                    .comment(Comment.builder()
                            .description("description" + 1)
                            .build())
                    .build(),
            Post.builder()
                    .id(2L)
                    .text("text " + 2)
                    .comment(Comment.builder()
                            .description("description" + 2)
                            .build())
                    .build());


    @GraphQLQuery
    public Post post(@GraphQLArgument(name = "id") final Long id) {
        return Post.builder()
                .id(id)
                .text("text " + id)
                .comment(Comment.builder()
                        .description("description" + id)
                        .build())
                .build();
    }

    @GraphQLQuery
    public List<Post> getPosts() {
        return posts;
    }

    @GraphQLQuery
    public List<Post> getPostsByToto() {
        return posts;
    }

    @GraphQLQuery
    public List<Post> getPostsById(Long id) {
        return posts.stream()
                .filter(e -> e.getId() == id)
                .collect(Collectors.toList());
    }



}