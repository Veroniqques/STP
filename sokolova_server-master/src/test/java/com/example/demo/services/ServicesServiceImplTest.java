package com.example.demo.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesServiceImplTest {

    @Autowired
    private ServicesServiceImpl servicesService;
    @MockBean
    private ServicesRepo servicesRepo;

    @Test
    public void readAll() {
        List<Services> expected = new ArrayList<>();
        Mockito.when(servicesRepo.findAll()).thenReturn(expected);
        List<Services> services = servicesService.readAll();
        Assertions.assertEquals(expected, services);
    }

    @Test
    public void create() {
        Services services = new Services();
        Services expected = new Services();
        expected.setId(1L);
        Mockito.when(servicesRepo.save(services)).thenReturn(expected);
        Services actual = servicesService.create(services);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void read() {
        Services services = new Services();
        services.setId(1L);
        Optional<Services> expected = Optional.of(services);
        Mockito.when(servicesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertEquals(services, servicesService.read(1L));
    }

    @Test
    public void update() {
        Services services = new Services();
        services.setId(1L);
        Optional<Services> expected = Optional.of(services);
        Mockito.when(servicesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(servicesService.update(services, 1L));
    }

    @Test
    public void delete() {
        Services services = new Services();
        services.setId(1L);
        Optional<Services> expected = Optional.of(services);
        Mockito.when(servicesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(servicesService.delete(1L));
    }
}