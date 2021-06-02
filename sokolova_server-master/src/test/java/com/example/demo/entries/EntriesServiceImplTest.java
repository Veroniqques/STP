package com.example.demo.entries;

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
public class EntriesServiceImplTest {

    @Autowired
    private EntriesServiceImpl entriesService;
    @MockBean
    private EntriesRepo entriesRepo;

    @Test
    public void create() {
        Entries entries = new Entries();
        Entries expected = new Entries();
        expected.setId(1L);
        Mockito.when(entriesRepo.save(entries)).thenReturn(expected);
        Entries actual = entriesService.create(entries);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void readAll() {
        List<Entries> expected = new ArrayList<>();
        Mockito.when(entriesRepo.findAll()).thenReturn(expected);
        List<Entries> entries = entriesService.readAll();
        Assertions.assertEquals(expected, entries);
    }

    @Test
    public void read() {
        Entries entries = new Entries();
        entries.setId(1L);
        Optional<Entries> expected = Optional.of(entries);
        Mockito.when(entriesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertEquals(entries, entriesService.read(1L));
    }

    @Test
    public void update() {
        Entries entries = new Entries();
        entries.setId(1L);
        Optional<Entries> expected = Optional.of(entries);
        Mockito.when(entriesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(entriesService.update(entries, 1L));
    }

    @Test
    public void delete() {
        Entries entries = new Entries();
        entries.setId(1L);
        Optional<Entries> expected = Optional.of(entries);
        Mockito.when(entriesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(entriesService.delete(1L));
    }
}