package com.example.demo.clients;

import com.example.demo.entries.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для {@link Clients}
 */
@RestController
public class ClientsController {

    private final ClientsService clientsService;
    private final EntriesService entriesService;

    /**
     * Инициализация контроллера для сущности клиента
     * @param clientsService - clients Service
     * @param entriesService - entries Service
     */
    @Autowired
    public ClientsController(ClientsService clientsService, EntriesService entriesService) {
        this.clientsService = clientsService;
        this.entriesService = entriesService;
    }

    /**
     * Получение списка всех клиентов
     * @return  - Возвращает клиентов, если те содержат элементы; Ошибку,если не найден
     */
    @GetMapping(value = "/clients")
    public ResponseEntity<List<Clients>> readClients() {
        final List<Clients> clients = clientsService.readAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение клиента по id
     * @param id - идентификатор клиента
     * @return - Возвращает клиента, если он существует; NOT_FOUND, если не найден
     */
    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Clients> readClient(@PathVariable(name = "id") int id) {
        final Clients client = clientsService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение клиента
     * @param client - новая информация о клиенте
     * @param id - идентификатор клиента
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> updateClient(@RequestBody Clients client, @PathVariable(name = "id") int id) {
        if (clientsService.update(client, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление клиента по id
     * @param id - идентификатор клиента
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") int id) {
        if (clientsService.read(id) != null) {
            entriesService.deleteByClientId(id);
            clientsService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Добавление клиента
     * @param client - информация о клиенте
     * @return - Добавленный клиент
     */
    @PostMapping("/clients")
    public Clients createNewClient(@RequestBody Clients client) {
        return clientsService.create(client);
    }
}
