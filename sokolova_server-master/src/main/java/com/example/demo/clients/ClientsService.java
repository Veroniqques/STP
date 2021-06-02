package com.example.demo.clients;

import java.util.List;

public interface ClientsService {

    Clients create(Clients client);

    List<Clients> readAll();

    Clients read(long id);

    boolean update(Clients client, long id);

    boolean delete(long id);

}
