package com.CoffeeGroup.Coffee.System.common.Model;

public interface IMapper <T,U>{
    T toEnity(U u);
    U toDto(T t);
}
