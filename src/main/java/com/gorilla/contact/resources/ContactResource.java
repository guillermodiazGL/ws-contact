package com.gorilla.contact.resources;

import com.gorilla.contact.model.ContactRequest;
import com.gorilla.contact.services.ContactService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/contacts")
@Singleton
public class ContactResource {

    @Inject
    private ContactService contactService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContacts(){
       return Response.ok(contactService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContact(@PathParam("id") String id){
        return Response.ok(contactService.findById(id)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createContact(ContactRequest contactRequest){
        this.contactService.createContact(contactRequest);
        return Response.ok().build();
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContact(ContactRequest contactRequest){
        this.contactService.updateContact(contactRequest);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteContact(@PathParam("id") String id){
        this.contactService.deleteContact(id);
        return Response.ok().build();
    }


}
