package com.dto_project.dto_project.mapper;

import com.dto_project.dto_project.dto.UserDto;
import com.dto_project.dto_project.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
