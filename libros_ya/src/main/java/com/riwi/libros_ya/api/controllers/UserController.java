package com.riwi.libros_ya.api.controllers;

import com.riwi.libros_ya.api.dto.request.UserRequest;
import com.riwi.libros_ya.api.dto.request.UserUpdateRequest;
import com.riwi.libros_ya.api.dto.response.UserResponse;
import com.riwi.libros_ya.infraestructure.abstract_serives.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


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

    @GetMapping(path ="/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id,
                                            @RequestBody UserUpdateRequest request){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(request.getUsername());
        userRequest.setPassword(request.getPassword());
        userRequest.setEmail(request.getEmail());
        userRequest.setFull_name(request.getFull_name());

        return  ResponseEntity.ok(this.userService.update(id, userRequest));
    }
}
