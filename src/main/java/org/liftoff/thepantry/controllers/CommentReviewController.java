package org.liftoff.thepantry.controllers;

import org.liftoff.thepantry.data.CommentReviewRepository;
import org.liftoff.thepantry.data.RecipeRepository;
import org.liftoff.thepantry.models.Recipe;
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
public class CommentReviewController {

    @Autowired
    private CommentReviewRepository commentRepository;

    @PostMapping("add-recipe") // fix for comments
    public String addRecipe(Model model, @ModelAttribute @Valid Recipe newRecipe, Errors errors, RedirectAttributes ra) {
        // error checking
        if (errors.hasErrors()) {
            model.addAttribute("recipes", recipeRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
            return "admin/recipes/index";
        }
        if (!recipeRepository.findByName(newRecipe.getName()).isEmpty()) {
            ra.addFlashAttribute("class", "alert alert-danger");
            ra.addFlashAttribute("message", "Recipe '" + newRecipe.getName() + "' already exists.");
            return "redirect:/admin/recipes/";
        }

        // save recipe
        //CHANGE TO save comment and code below
        recipeRepository.save(newRecipe);
        int recipeId = newRecipe.getId();
        return "redirect:/admin/recipes/edit/" + recipeId;
    }



}
