package com.gorilla.contact.converters;

import com.gorilla.contact.entities.ContactEntity;
import com.gorilla.contact.model.ContactResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ContactListToResponseListConverter  implements Converter<List<ContactEntity>, List<ContactResponse>> {

    @Inject
    ContactToResponseConverter converter;

    @Override
    public List<ContactResponse> convert(List<ContactEntity> source) {
        List<ContactResponse> list=new ArrayList<>();

        for(ContactEntity contact:source)
            list.add(converter.convert(contact));

        return list;
    }

}
