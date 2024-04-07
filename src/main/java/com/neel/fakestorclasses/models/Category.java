package com.neel.fakestorclasses.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {
    private Long id;
    private String title;
    private String description;
}