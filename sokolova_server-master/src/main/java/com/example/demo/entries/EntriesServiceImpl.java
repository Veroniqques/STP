package com.example.demo.entries;

import com.example.demo.clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Сервис для {@link Entries}
 */
@Service
public class EntriesServiceImpl implements EntriesService {

    @Autowired
    private EntriesRepo entriesRepo;

    /**
     * Создание записи
     * @param entry - информация о записи
     * @return - созданная запись
     */
    @Override
    public Entries create(Entries entry) {
        return entriesRepo.save(entry);
    }

    /**
     * Получает список всех записей
     * @return - возвращает список записей
     */
    @Override
    public List<Entries> readAll() {
        return entriesRepo.findAll(Sort.by(Sort.Direction.ASC, "date", "time"));
    }

    /**
     * Получение записи
     * @param id - идентификатор записи
     * @return - возвращает одну запись по id; null, если запись не найдена
     */
    @Override
    public Entries read(long id) {
        return entriesRepo.findById(id).orElse(null);
    }

    /**
     * Изменение записи
     * @param entry - информация о записи
     * @param id - идентификатор записи
     * @return - boolean
     */
    @Override
    public boolean update(Entries entry, long id) {
        if (read(id) != null) {
            Entries updatedEntry = new Entries();
            updatedEntry.setConfirmed(entry.isConfirmed());
            updatedEntry.setClient(entry.getClient());
            updatedEntry.setDate(entry.getDate());
            updatedEntry.setTime(entry.getTime());
            updatedEntry.setEmployee(entry.getEmployee());
            updatedEntry.setId(id);
            updatedEntry.setService(entry.getService());

            entriesRepo.save(updatedEntry);
            return true;
        }

        return false;
    }

    /**
     * Удаление клиента
     * @param id - идентификатор записи
     * @return - boolean
     */
    @Override
    public boolean delete(long id) {
        if (read(id) != null) {
            entriesRepo.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * Получение записей по id клаиента
     * @param id - идентификатор клиента
     * @return - найденные записи
     */
    @Override
    public List<Entries> findAllByClientId(long id) {
        return entriesRepo.findAllByClientId(id);
    }

    /**
     * Удаляет записи по id клиента
     * @param id - идентификатор клиента
     * @return - boolean
     */
    @Override
    public boolean deleteByClientId(long id) {
        entriesRepo.deleteAll(findAllByClientId(id));
        return true;
    }

    /**
     * Получение записей по id сотрудника
     * @param id - идентификатор сотрудника
     * @return - найденные записи
     */
    @Override
    public List<Entries> findAllByEmployeeId(long id) {
        return entriesRepo.findAllByEmployeeId(id);
    }

    /**
     * Удаляет записи по id сотрудника
     * @param id - идентификатор сотрудника
     * @return - boolean
     */
    @Override
    public boolean deleteByEmployeeId(long id) {
        entriesRepo.deleteAll(findAllByEmployeeId(id));
        return true;
    }

    /**
     * Получение записей по id услуги
     * @param id - идентификатор услуги
     * @return - найденные услуги
     */
    @Override
    public List<Entries> findAllByServiceId(long id) {
        return entriesRepo.findAllByServiceId(id);
    }

    /**
     * Удаляет записи по id услуги
     * @param id - идентификатор услуги
     * @return - boolean
     */
    @Override
    public boolean deleteByServiceId(long id) {
        entriesRepo.deleteAll(findAllByServiceId(id));
        return true;
    }
}
