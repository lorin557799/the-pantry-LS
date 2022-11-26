package org.liftoff.thepantry.controllers;

import org.liftoff.thepantry.data.ReviewRepository;
import org.liftoff.thepantry.models.Recipe;
import org.liftoff.thepantry.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("review") // fix for comments
    public String addReview(Model model, @ModelAttribute @Valid Review newReview, Errors errors, RedirectAttributes ra) {
        reviewRepository.save(newReview);
        return "redirect: index";
    }

}
