package main.common.domain;

import java.util.List;

public interface Repository<T, ID> {
    T save(T t);
    List<T> findAll();
}
