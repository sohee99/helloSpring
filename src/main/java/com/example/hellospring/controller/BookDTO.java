package com.example.hellospring.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class BookDTO {

        private String id;
        private String name;
        private String author;
}
