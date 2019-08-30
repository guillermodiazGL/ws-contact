package com.gorilla.contact.converters;

import com.gorilla.contact.entities.ContactEntity;
import com.gorilla.contact.model.ContactResponse;

public class ContactToResponseConverter implements Converter<ContactEntity, ContactResponse>  {
    @Override
    public ContactResponse convert(ContactEntity source) {
        if(source==null)
            return null;
        ContactResponse entity = new ContactResponse();
        entity.setEmail(source.getEmail());
        entity.setId(source.getId());
        entity.setLastName(source.getLastName());
        entity.setName(source.getName());
        entity.setPhone(source.getPhoneNumber());
        return entity;
    }
}
