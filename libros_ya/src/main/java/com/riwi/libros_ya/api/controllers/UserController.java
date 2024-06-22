package com.riwi.libros_ya.api.controllers;

import com.riwi.libros_ya.api.dto.request.UserRequest;
import com.riwi.libros_ya.api.dto.response.UserResponse;
import com.riwi.libros_ya.infraestructure.abstract_serives.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> insert(
            @RequestBody UserRequest request){
        return ResponseEntity.ok(this.userService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }
}
