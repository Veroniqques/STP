package com.example.demo.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для {@link Clients}
 */
@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepo clientsRepo;

    /**
     * Создание клента
     * @param client - информация о клиенте
     * @return - созданный клиент
     */
    @Override
    public Clients create(Clients client) {
        return clientsRepo.save(client);
    }

    /**
     * Получает список всех клиенов
     * @return возвращает список клиенов
     */
    @Override
    public List<Clients> readAll() {
        return clientsRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    /**
     * Получение клиента
     * @param id - идентификатор клиента
     * @return - возвращает одного клиента по id; null, если клиент не найден
     */
    @Override
    public Clients read(long id) {
        return clientsRepo.findById(id).orElse(null);
    }

    /**
     * Изменение клиента
     * @param client - информация о клиенте
     * @param id - идентификатор клиента
     * @return - boolean
     */
    @Override
    public boolean update(Clients client, long id) {
        if (read(id) != null) {
            Clients updatedClient = new Clients();
            updatedClient.setId(id);
            updatedClient.setBirthday(client.getBirthday());
            updatedClient.setEmail(client.getEmail());
            updatedClient.setName(client.getName());
            updatedClient.setPhone(client.getPhone());
            updatedClient.setStatus(client.getStatus());
            clientsRepo.save(updatedClient);
            System.out.println("updated");
            return true;

        }

        return false;
    }

    /**
     * Удаление клиента
     * @param id - идентификатор клиента
     * @return - boolean
     */
    @Override
    public boolean delete(long id) {
        if (read(id) != null) {
            clientsRepo.deleteById(id);
            return true;
        }

        return false;
    }
}
