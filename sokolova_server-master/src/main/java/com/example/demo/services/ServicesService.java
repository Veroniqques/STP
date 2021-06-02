package com.example.demo.services;

import java.util.List;

public interface ServicesService {

    Services create(Services service);

    List<Services> readAll();

    Services read(long id);

    boolean update(Services service, long id);

    boolean delete(long id);

}
