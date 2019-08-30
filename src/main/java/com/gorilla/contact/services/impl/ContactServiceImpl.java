package com.gorilla.contact.services.impl;

import com.gorilla.contact.converters.ContactListToResponseListConverter;
import com.gorilla.contact.converters.ContactToResponseConverter;
import com.gorilla.contact.converters.RequestToContactConverter;
import com.gorilla.contact.entities.ContactEntity;
import com.gorilla.contact.model.ContactRequest;
import com.gorilla.contact.model.ContactResponse;
import com.gorilla.contact.repositories.CrudRepository;
import com.gorilla.contact.services.ContactService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ContactServiceImpl implements ContactService {

    @Inject
    private CrudRepository<ContactEntity, String> contactRepository;

    @Inject
    ContactToResponseConverter contactToResponseConverter;

    @Inject
    RequestToContactConverter requestToContactConverter;

    @Inject
    ContactListToResponseListConverter contactListToResponseListConverter;

    @Override
    public ContactResponse createContact(ContactRequest contactRequest) {
        ContactEntity entity = requestToContactConverter.convert(contactRequest);
        entity =  contactRepository.save(entity);
        return contactToResponseConverter.convert(entity);
    }

    @Override
    public ContactResponse updateContact(ContactRequest contactRequest) {
        ContactEntity entity = requestToContactConverter.convert(contactRequest);
        entity =  contactRepository.save(entity);
        return contactToResponseConverter.convert(entity);
    }

    @Override
    public void deleteContact(String id) {
        this.contactRepository.removeBy(id);
    }

    @Override
    public ContactResponse findById(String id){

        ContactEntity result = contactRepository.findById(id);
		return contactToResponseConverter.convert(result);
    }

    @Override
    public List<ContactResponse> findAll() {
        List<ContactEntity> results = (List<ContactEntity>) contactRepository.findAll();
        return contactListToResponseListConverter.convert(results);
    }
}
