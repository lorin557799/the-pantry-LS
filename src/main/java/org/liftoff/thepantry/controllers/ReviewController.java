package org.liftoff.thepantry.controllers;

import org.liftoff.thepantry.data.ReviewRepository;
import org.liftoff.thepantry.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("")
    public String review(Model model) {
        model.addAttribute("banner", "review");
        model.addAttribute(new Review());
        return "review/index";
    }

    @PostMapping("add-review")
    public String addReview(Model model, @ModelAttribute @Valid Review review, Errors errors, RedirectAttributes ra) {
//        reviewRepository.save(review);
        return "redirect:/review";
    }
}
