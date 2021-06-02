package com.example.demo.entries;

import java.util.List;

public interface EntriesService {

    Entries create(Entries entry);

    List<Entries> readAll();

    Entries read(long id);

    boolean update(Entries entry, long id);

    boolean delete(long id);

    List<Entries> findAllByClientId(long id);

    boolean deleteByClientId(long id);

    List<Entries> findAllByEmployeeId(long id);

    boolean deleteByEmployeeId(long id);

    List<Entries> findAllByServiceId(long id);

    boolean deleteByServiceId(long id);

}
