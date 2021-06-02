package com.example.demo.shares;

import com.example.demo.clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Контроллер для {@link Shares}
 */
@RestController
public class SharesController {

    private final SharesService sharesService;

    /**
     * Инициализация контроллера для сущности акции
     * @param sharesService - shares Service
     */
    @Autowired
    public SharesController(SharesService sharesService) {
        this.sharesService = sharesService;
    }

    /**
     * Получение списка всех акций
     * @return - Возвращает акции, если те содержат элементы; Ошибку,если не найден
     */
    @GetMapping(value = "/shares")
    public ResponseEntity<List<Shares>> readShares() {
        final List<Shares> shares = sharesService.readAll();

        return shares != null && !shares.isEmpty()
                ? new ResponseEntity<>(shares, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение акции по id
     * @param id - идентификатор акции
     * @return - Возвращает акцию, если он существует; NOT_FOUND, если не найден
     */
    @GetMapping(value = "/shares/{id}")
    public ResponseEntity<Shares> readShare(@PathVariable(name = "id") int id) {
        final Shares share = sharesService.read(id);

        return share != null
                ? new ResponseEntity<>(share, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение акции
     * @param share - новая информация об акции
     * @param id - идентификатор акции
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @PutMapping(value = "/shares/{id}")
    public ResponseEntity<?> updateShare(@RequestBody Shares share, @PathVariable(name = "id") int id) {
        if (sharesService.update(share, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление акции по id
     * @param id - идентификатор акции
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @DeleteMapping(value = "/shares/{id}")
    public ResponseEntity<?> deleteShare(@PathVariable(name = "id") int id) {
        if (sharesService.read(id) != null) {
            sharesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Добавление акции
     * @param share - информация об акции
     * @return - Добавленная акция
     */
    @PostMapping("/shares")
    public Shares createNewShare(@RequestBody Shares share) {
        return sharesService.create(share);
    }

}
