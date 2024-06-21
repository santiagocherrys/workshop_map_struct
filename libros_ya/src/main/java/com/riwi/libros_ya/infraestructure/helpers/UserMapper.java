package com.riwi.libros_ya.infraestructure.helpers;

import com.riwi.libros_ya.api.dto.request.UserRequest;
import com.riwi.libros_ya.api.dto.response.UserResponse;
import com.riwi.libros_ya.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User UserReqToEntity(UserRequest userReq);

    UserResponse EntityToUserResp(User user);


}
