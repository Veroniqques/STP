package com.example.demo.shares;

import java.util.List;

public interface SharesService {

    Shares create(Shares share);

    List<Shares> readAll();

    Shares read(long id);

    boolean update(Shares share, long id);

    boolean delete(long id);

}
