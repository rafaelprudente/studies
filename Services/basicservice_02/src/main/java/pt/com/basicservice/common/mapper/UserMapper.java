package pt.com.basicservice.common.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pt.com.basicservice.common.dto.User;
import pt.com.basicservice.controller.user.UserResponse;
import pt.com.basicservice.persistence.user.UserEntity;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class UserMapper {
    public abstract UserEntity modelToEntity(User user);

    @Mapping(target = "id", ignore = true)
    public abstract void replace(User model, @MappingTarget UserEntity entity);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void change(User model, @MappingTarget UserEntity entity);

    public User entityToModel(UserEntity entity) {
        return new User(entity.getId(), entity.getName(), entity.getLastname());
    }

    public Collection<User> entityListToModelList(Collection<UserEntity> entities) {
        return entities.stream().map(this::entityToModel).toList();
    }

    public abstract UserResponse modelToResponse(User model);

    public abstract Collection<UserResponse> modelListToResponseList(Collection<User> modelList);
}
