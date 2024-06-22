package com.riwi.libros_ya.api.controllers;

import org.springframework.web.bind.annotation.*;

import com.riwi.libros_ya.api.dto.request.BookRequest;
import com.riwi.libros_ya.api.dto.response.BookResponse;
import com.riwi.libros_ya.infraestructure.abstract_serives.IBookService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class BookController{
    
    @Autowired
    private final IBookService bookService;
    
    @PostMapping
    public ResponseEntity<BookResponse> insert(@RequestBody BookRequest request){
        return ResponseEntity.ok(this.bookService.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<BookResponse>> getAll() {
        return ResponseEntity.ok(this.bookService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.bookService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable Long id,
                                               @RequestBody BookRequest request){
        return ResponseEntity.ok(this.bookService.update(id,request));
    }
    
}
