package com.riwi.libros_ya.infraestructure.abstract_serives;

import com.riwi.libros_ya.api.dto.request.BookRequest;
import com.riwi.libros_ya.api.dto.response.BookResponse;

public interface IBookService extends CrudService<BookRequest,BookResponse,Long>  {
    
}
