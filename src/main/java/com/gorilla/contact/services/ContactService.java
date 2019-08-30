package com.gorilla.contact.services;

import com.gorilla.contact.model.ContactRequest;
import com.gorilla.contact.model.ContactResponse;

import java.util.List;

public interface ContactService {
    /**
     * Method that inserts a contact into the database
     * @return contactResponse
     */
    ContactResponse createContact(ContactRequest contactRequest);

    /**
     * Method that updates a contact into the database
     * @return contactResponse
     */
    ContactResponse updateContact(ContactRequest contactRequest);

    /**
     * Method that deletes an specific contact
     * @param id
     */
    void deleteContact(String id);

    /**
     * Find by Id
     * @param id
     * @return responses
     */
    ContactResponse findById(String id);

    /**
     * Find all contacts
     * @return responses
     */
    List<ContactResponse> findAll();

}
