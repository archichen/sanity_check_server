package com.cxx.server.service;

import com.cxx.server.dto.ResponseDTO;

import java.util.List;

// T is the DTO class, V is the VO class
public interface CommonCRUDService<T, V> {
    ResponseDTO<V> create(T t);

    ResponseDTO<V> update(T t);

    void delete(Long id);

    ResponseDTO<V> get(Long id);
}
