package com.OnceFactoriaF5.miemakeup.dtos.consumer;

import com.OnceFactoriaF5.miemakeup.models.Consumer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConsumerMapper {
    ConsumerMapper INSTANCE = Mappers.getMapper(ConsumerMapper.class);
    ConsumerDTOResponse consumerToConsumerDTOResponse(Consumer consumer);
}
