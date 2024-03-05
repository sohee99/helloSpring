package com.example.hellospring.controller;


import com.example.hellospring.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class BookController {

    private  final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String home(Model model){
        List<BookDTO> bookList = bookRepository.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "bookManager";
    }

    @PostMapping("/books")
    public String saveBook(@RequestParam("id") String id,
                           @RequestParam("name") String name,
                           @RequestParam("author") String author){
        System.out.println( id + name + author);

        //todo save
            bookRepository.saveBook(new BookDTO(id, name, author));

        return  "redirect:/books";
        //기본 메소드 : /books > get메소드로 호출됨 ( 내부처리 후 GET/books 호출 )
        // redirect : 사용자가 처음 요청한 url 이아닌 다른 url로 보내는 것
    }

    @GetMapping("/books/{id}")
    public  String detail(@PathVariable("id") String isbn,Model model){
        System.out.println("isbn = " + isbn);
        log.info("isbn = " + isbn); //출력하고싶은 문자열 입력

        //TODO 화면에 보여줄 book

        BookDTO book = bookRepository.getBook(isbn);
        model.addAttribute("book", book);
        //model.addAttribute("book", bookRepository.getbook(isbn)); 바로 넣을 수도 있음

        return "bookDetail";
    }

}
