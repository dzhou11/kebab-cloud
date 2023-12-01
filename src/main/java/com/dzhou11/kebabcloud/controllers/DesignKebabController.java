package com.dzhou11.kebabcloud.controllers;

import com.dzhou11.kebabcloud.models.Ingredient;
import com.dzhou11.kebabcloud.models.Order;
import com.dzhou11.kebabcloud.models.Skewer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignKebabController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("LMBL", "Lamb meat(lean)", Ingredient.Type.PROTIEN),
                new Ingredient("LMBF", "Lamb meat(fat)", Ingredient.Type.PROTIEN),
                new Ingredient("CHKN", "Chiken meat", Ingredient.Type.PROTIEN),
                new Ingredient("BEEF", "Beef", Ingredient.Type.PROTIEN),
                new Ingredient("PPRG", "Green pepper", Ingredient.Type.VEGGIES),
                new Ingredient("PPRR", "Red pepper", Ingredient.Type.VEGGIES),
                new Ingredient("ONIN", "Onion", Ingredient.Type.VEGGIES),
                new Ingredient("CHIL", "Chili", Ingredient.Type.SAUCE),
                new Ingredient("CMIN", "Cumin", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "Skewer")
    public Skewer skewer() {
        return new Skewer();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
