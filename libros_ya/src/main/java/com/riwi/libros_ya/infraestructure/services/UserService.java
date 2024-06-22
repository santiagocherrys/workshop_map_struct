package com.riwi.libros_ya.infraestructure.services;

import com.riwi.libros_ya.api.dto.request.UserRequest;
import com.riwi.libros_ya.api.dto.response.UserResponse;
import com.riwi.libros_ya.domain.entities.User;
import com.riwi.libros_ya.domain.repositories.UserRepository;
import com.riwi.libros_ya.infraestructure.abstract_serives.IUserService;
import com.riwi.libros_ya.infraestructure.helpers.UserMapper;
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

    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = this.userMapper.UserReqToEntity(userRequest);
        //Se setea la listas vacias
        user = this.userRepository.save(user);
        user.setReservations(new ArrayList<>());
        user.setLoans(new ArrayList<>());
        System.out.println("esto es user " + user);
        return this.userMapper.EntityToUserResp(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public List<UserResponse> getAll(){

        return this.userMapper.listEntitiesToUserResp(this.userRepository.findAll());
    }

    @Override
    public UserResponse getById(Long id){
        return null;
    }
}
