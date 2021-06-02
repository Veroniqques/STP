package com.example.demo.shares;

import com.example.demo.employees.Employees;
import com.example.demo.entries.Entries;
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
public class SharesServiceImplTest {

    @Autowired
    private SharesServiceImpl sharesService;
    @MockBean
    private SharesRepo sharesRepo;

    @Test
    public void create() {
        Shares shares = new Shares();
        Shares expected = new Shares();
        expected.setId(1L);
        Mockito.when(sharesRepo.save(shares)).thenReturn(expected);
        Shares actual = sharesService.create(shares);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void readAll() {
        List<Shares> expected = new ArrayList<>();
        Mockito.when(sharesRepo.findAll()).thenReturn(expected);
        List<Shares> shares = sharesService.readAll();
        Assertions.assertEquals(expected, shares);
    }

    @Test
    public void read() {
        Shares shares = new Shares();
        shares.setId(1L);
        Optional<Shares> expected = Optional.of(shares);
        Mockito.when(sharesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertEquals(shares, sharesService.read(1L));
    }

    @Test
    public void update() {
        Shares shares = new Shares();
        shares.setId(1L);
        Optional<Shares> expected = Optional.of(shares);
        Mockito.when(sharesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(sharesService.update(shares, 1L));
    }

    @Test
    public void delete() {
        Shares shares = new Shares();
        shares.setId(1L);
        Optional<Shares> expected = Optional.of(shares);
        Mockito.when(sharesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(sharesService.delete(1L));
    }
}