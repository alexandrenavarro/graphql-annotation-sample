package com.github.alexandrenavarro.graphqlsample.api;

import com.github.alexandrenavarro.graphqlsample.model.Post;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@GraphQLApi
public class Mutation {

    @GraphQLMutation
    public Post createPost(String text){
        final Post post = new Post();
        post.setId(new Random().nextLong());
        post.setText(text);
        return post;
    }
}
