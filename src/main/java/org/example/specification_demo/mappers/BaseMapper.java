package org.example.specification_demo.mappers;

public interface BaseMapper<T, U, V> {
    T toDto(U u);
    U toEntity(V v);
}
