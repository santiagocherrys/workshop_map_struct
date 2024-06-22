package com.riwi.libros_ya.infraestructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.libros_ya.api.dto.request.BookRequest;
import com.riwi.libros_ya.api.dto.response.BookResponse;
import com.riwi.libros_ya.domain.entities.Book;
import com.riwi.libros_ya.domain.repositories.BookRepository;
import com.riwi.libros_ya.infraestructure.abstract_serives.IBookService;
import com.riwi.libros_ya.infraestructure.helpers.BookMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final BookMapper bookMapper;

    @Override
    public void delete(Long id) {
        this.bookRepository.delete(this.find(id));
    }

    @Override
    public BookResponse create(BookRequest request){
        Book book = this.bookMapper.bookReqToEntity(request);

        //Se setean listas vacias
        book.setLoans(new ArrayList<>());
        book.setReservations(new ArrayList<>());
        book =  this.bookRepository.save(book);
        
        System.out.println("Esto es book " + book);

        return this.bookMapper.entityToBookResp(book);
        
    }

    @Override
    public BookResponse update(Long id, BookRequest request) {
        Book book = this.find(id);
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublication_year(request.getPublication_year());
        book.setGenre(request.getGenre());
        book.setIsbn(request.getIsbn());

        return this.bookMapper.entityToBookResp(this.bookRepository.save(book));

    }

    @Override
    public List<BookResponse> getAll(){
       return this.bookMapper.listEntitiestoBookResp(this.bookRepository.findAll());
    }

    @Override
    public BookResponse getById(Long id) {

        return this.bookMapper.entityToBookResp(this.find(id));
    }

    private Book find(Long id){
        return this.bookRepository.findById(id).orElseThrow();
    }
    
}
