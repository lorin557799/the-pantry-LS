package org.liftoff.thepantry.models;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class CommentReview extends AbstractEntity {

    OneToOne
    @JoinColumn(name = "recipe-id", referencedColumnName = "id")
    private Recipe recipe;



}
