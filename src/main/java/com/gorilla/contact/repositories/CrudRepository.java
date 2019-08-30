package com.gorilla.contact.repositories;

import com.gorilla.contact.entities.ContactEntity;

import javax.inject.Singleton;
import java.util.Collection;


public interface CrudRepository<E,ID> {

    E save(E entity);

    E findById(ID id);

    Collection<E> findAll();

    Collection<E> findAll(int start, int max);

    void remove(E entity);

    void removeBy(ID id);

}
