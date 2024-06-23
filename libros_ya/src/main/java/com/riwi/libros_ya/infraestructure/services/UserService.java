package com.riwi.libros_ya.infraestructure.services;

import com.riwi.libros_ya.api.dto.request.UserRequest;
import com.riwi.libros_ya.api.dto.response.UserResponse;
import com.riwi.libros_ya.domain.entities.User;
import com.riwi.libros_ya.domain.repositories.UserRepository;
import com.riwi.libros_ya.infraestructure.abstract_serives.IUserService;
import com.riwi.libros_ya.infraestructure.helpers.UserMapper;
import com.riwi.libros_ya.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public void delete(Long id) {
        this.userRepository.delete(this.find(id));
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = this.userMapper.UserReqToEntity(userRequest);
        //Se setea la listas vacias
        user.setReservations(new ArrayList<>());
        user.setLoans(new ArrayList<>());
        user = this.userRepository.save(user);
    
        System.out.println("esto es user " + user);
        return this.userMapper.EntityToUserResp(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        //Se busca el usuario
        User user = this.find(id);
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setFull_name(userRequest.getFull_name());
        
        return this.userMapper.EntityToUserResp(this.userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAll(){

        return this.userMapper.listEntitiesToUserResp(this.userRepository.findAll());
    }

    @Override
    public UserResponse getById(Long id){
        return this.userMapper.EntityToUserResp(this.find(id));
    }

    private User find(Long id){
        return this.userRepository.findById(id).orElseThrow(()-> new IdNotFoundException("User"));
    }
}
