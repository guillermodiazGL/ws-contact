package com.gorilla.contact.entities;

import dev.morphia.annotations.*;


@Entity("contacts")
@Indexes({
        @Index(fields = @Field("id")),
        @Index(fields = @Field("name"))
})
public class ContactEntity {


    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
