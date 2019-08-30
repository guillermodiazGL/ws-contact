package com.gorilla.contact.converters;


import com.gorilla.contact.entities.ContactEntity;
import com.gorilla.contact.model.ContactRequest;

import javax.inject.Singleton;

@Singleton
public class RequestToContactConverter implements Converter<ContactRequest, ContactEntity> {

    @Override
    public ContactEntity convert(ContactRequest contactRequest) {
        ContactEntity entity = new ContactEntity();
        entity.setEmail(contactRequest.getEmail());
        entity.setId(contactRequest.getId());
        entity.setLastName(contactRequest.getLastName());
        entity.setName(contactRequest.getName());
        entity.setPhoneNumber(contactRequest.getPhone());
        return entity;
    }
}
