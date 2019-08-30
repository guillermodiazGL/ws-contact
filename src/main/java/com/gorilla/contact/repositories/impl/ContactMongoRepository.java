package com.gorilla.contact.repositories.impl;

import com.gorilla.contact.entities.ContactEntity;
import com.gorilla.contact.repositories.CrudRepository;
import dev.morphia.Datastore;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;


@Singleton
public class ContactMongoRepository implements CrudRepository<ContactEntity, String> {

    @Inject
    private Datastore datastore;


    @Override
    public ContactEntity save(ContactEntity entity) {
        if (null == this.findById(entity.getId())) {
            this.datastore.save(entity);
        } else {
            UpdateOperations<ContactEntity> updateOperations = this.datastore.createUpdateOperations(ContactEntity.class);
            updateOperations
                    .set("id", entity.getId())
                    .set("name", entity.getName() )
                    .set("lastName", entity.getLastName() )
                    .set("email", entity.getEmail())
                    .set("phoneNumber", entity.getPhoneNumber());
            this.datastore.update(this.datastore.createQuery(ContactEntity.class).field("id").equal(entity.getId()), updateOperations);
        }

        return entity;
    }

    @Override
    public ContactEntity findById(String s) {
        ContactEntity contactEntity = this.datastore.createQuery(ContactEntity.class).field("id").equal(s).first();
        return contactEntity;
    }

    @Override
    public Collection<ContactEntity> findAll() {
        final Query<ContactEntity> query = datastore.createQuery(ContactEntity.class);
        return query.find().toList();
    }

    @Override
    public Collection<ContactEntity> findAll(int start, int max) {
        final Query<ContactEntity> query = datastore.createQuery(ContactEntity.class);
        return query.find(new FindOptions().limit(max).skip(start)).toList();
    }

    @Override
    public void remove(ContactEntity entity) {
        this.datastore.delete(entity);
    }

    @Override
    public void removeBy(String id) {
        this.datastore.delete(this.datastore.createQuery(ContactEntity.class).field("id").equal(id));

    }

}
