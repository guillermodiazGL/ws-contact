package com.gorilla.contact.converters;

public interface Converter<Origin,Target> {

    Target convert (Origin o);
}
