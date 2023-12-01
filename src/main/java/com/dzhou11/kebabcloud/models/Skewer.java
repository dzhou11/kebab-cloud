package com.dzhou11.kebabcloud.models;


import lombok.Data;

import java.util.List;

@Data
public class Skewer {
    private String name;
    private List<Ingredient> ingredients;
}
