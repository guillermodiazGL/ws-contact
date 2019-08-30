package com.gorilla.contact.startup;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

@Dependent
public class DataSourceFactory {


    @Inject
    @ConfigProperty(name = "mongo.client.host", defaultValue = "localhost")
    private String mongoHost;

    @Inject
    @ConfigProperty(name = "mongo.client.port", defaultValue = "27018")
    private Integer mongoPort;

    @Inject
    @ConfigProperty(name = "mongo.client.database", defaultValue = "contacts_db")
    private String mongoDatabase;

    @Inject
    @ConfigProperty(name = "mongo.client.sslEnabled", defaultValue = "false")
    private Boolean mongoSslEnabled;

    @Inject
    @ConfigProperty(name = "mongo.client.user", defaultValue = "mp-user")
    private String mongoUser;

    @Inject
    @ConfigProperty(name = "mongo.client.password", defaultValue = "12345")
    private String mongoPassword;



    @Singleton
    @Produces
    protected MongoClient mongoClient(){

        final MongoCredential credential = MongoCredential.createCredential(mongoUser, mongoDatabase, mongoPassword.toCharArray());
        final MongoClientOptions options = MongoClientOptions.builder().sslEnabled(mongoSslEnabled).build();
        final MongoClient mongoClient = new MongoClient(new ServerAddress(mongoHost, mongoPort),
                credential,
                options);

        return mongoClient;
    }


    @Singleton
    @Produces
    protected Datastore dataStore(){
        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.gorilla.contact.entities");
        final Datastore ds = morphia.createDatastore(this.mongoClient(), this.mongoDatabase);
        return ds;
    }



}
