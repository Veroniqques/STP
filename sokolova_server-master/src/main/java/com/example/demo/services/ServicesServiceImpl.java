package com.example.demo.services;

import com.example.demo.clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Сервис для {@link Services}
 */
@Service
public class ServicesServiceImpl implements ServicesService {


    @Autowired
    private ServicesRepo servicesRepo;

    /**
     * Получает список всех услуг
     * @return - возвращает список услуг
     */
    @Override
    public List<Services> readAll() {
        return servicesRepo.findAll();
    }

    /**
     * Создание услуги
     * @param service - информация об услуге
     * @return - созданная услуга
     */
    @Override
    public Services create(Services service) {
        return servicesRepo.save(service);
    }

    /**
     * Получение услуги
     * @param id - идентификатор услуги
     * @return - возвращает одну услугу по id; null, если клиент не найден
     */
    @Override
    public Services read(long id) {
        return servicesRepo.findById(id).orElse(null);
    }

    /**
     * Изменение услуги
     * @param service - информация об услуге
     * @param id - идентификатор услуги
     * @return - boolean
     */
    @Override
    public boolean update(Services service, long id) {
        if (read(id) != null) {
            Services updatedService = new Services();
            updatedService.setId(id);
            updatedService.setDescription(service.getDescription());
            updatedService.setName(service.getName());
            updatedService.setPrice(service.getPrice());
            updatedService.setShare(service.getShare());

            servicesRepo.save(updatedService);
            return true;
        }

        return false;
    }

    /**
     * Удаление клиента
     * @param id - идентификатор услуги
     * @return - boolean
     */
    @Override
    public boolean delete(long id) {
        if (read(id) != null) {
            servicesRepo.deleteById(id);
            return true;
        }

        return false;
    }
}
