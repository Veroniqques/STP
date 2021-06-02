package com.example.demo.services;

import com.example.demo.clients.Clients;
import com.example.demo.entries.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Контроллер для {@link Services}
 */
@RestController
public class ServicesController {

    private final ServicesService servicesService;
    private final EntriesService entriesService;

    /**
     * Инициализация контроллера для сущности услуги
     * @param servicesService - services Service
     * @param entriesService - entries Service
     */
    @Autowired
    public ServicesController(ServicesService servicesService, EntriesService entriesService) {
        this.servicesService = servicesService;
        this.entriesService = entriesService;
    }

    /**
     * Получение списка всех услуг
     * @return - Возвращает услуги, если те содержат элементы; Ошибку,если не найден
     */
    @GetMapping(value = "/services")
    public ResponseEntity<List<Services>> readServices() {
        final List<Services> services = servicesService.readAll();

        return services != null && !services.isEmpty()
                ? new ResponseEntity<>(services, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение услуги
     * @param service - новая информация об услуги
     * @param id - идентификатор услуги
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @PutMapping(value = "/services/{id}")
    public ResponseEntity<?> updateService(@RequestBody Services service, @PathVariable(name = "id") int id) {
        if (servicesService.update(service, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление услуги по id
     * @param id - идентификатор услуги
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @DeleteMapping(value = "/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable(name = "id") int id) {
        if (servicesService.read(id) != null) {
            entriesService.deleteByServiceId(id);
            servicesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Добавление услуги
     * @param service - информация об услуге
     * @return - Добавленный услуги
     */
    @PostMapping("/services")
    public Services createNewService(@RequestBody Services service) {
        return servicesService.create(service);
    }

}
