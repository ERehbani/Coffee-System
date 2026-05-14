package com.CoffeeGroup.Coffee.System.common.Model;


public interface IMapper <T,U>{
    T toEntity(U u);
    U toDto(T t);
}
