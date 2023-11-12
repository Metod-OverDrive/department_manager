package com.practice.departmentManager.web.mapper;

public interface Mappable<E, D>{

    E toEntity(D dto);

    D toDto(E entity);
}
