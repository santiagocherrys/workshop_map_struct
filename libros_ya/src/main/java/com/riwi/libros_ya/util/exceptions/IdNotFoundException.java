package com.riwi.libros_ya.util.exceptions;

public class IdNotFoundException extends RuntimeException{
    //%s para insertar variable
    private static final String ERROR_MESSAGE = "No hay registro en la entidad %s con el id suministrado";

    public IdNotFoundException(String nameEntity){
        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}
