package com.riwi.libros_ya.infraestructure.helpers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.libros_ya.api.dto.request.BookRequest;
import com.riwi.libros_ya.api.dto.response.BookResponse;
import com.riwi.libros_ya.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    Book bookReqToEntity(BookRequest bookRequest);

    BookResponse entityToBookResp(Book book);

    List<BookResponse> listEntitiestoBookResp(List<Book> books);
    
}
