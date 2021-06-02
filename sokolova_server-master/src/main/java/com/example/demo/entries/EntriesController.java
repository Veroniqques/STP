package com.example.demo.entries;

import com.example.demo.clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Контроллер для {@link Entries}
 */
@RestController
public class EntriesController {

    private final EntriesService entriesService;

    /**
     * Инициализация контроллера для сущности записи
     * @param entriesService - entries Service
     */
    @Autowired
    public EntriesController(EntriesService entriesService) {
        this.entriesService = entriesService;
    }

    /**
     * Получение списка всех записей
     * @return - Возвращает записи, если те содержат элементы; Ошибку,если не найдены
     */
    @GetMapping(value = "/entries")
    public ResponseEntity<List<Entries>> readEntries() {
        final List<Entries> entries = entriesService.readAll();

        return entries != null && !entries.isEmpty()
                ? new ResponseEntity<>(entries, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение записи по id
     * @param id - идентификатор записи
     * @return - Возвращает запись, если он существует; NOT_FOUND, если не найден
     */
    @GetMapping(value = "/entries/{id}")
    public ResponseEntity<Entries> readEntry(@PathVariable(name = "id") int id) {
        final Entries entry = entriesService.read(id);

        return entry != null
                ? new ResponseEntity<>(entry, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение записи
     * @param entry - новая информация о записи
     * @param id - идентификатор записи
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @PutMapping(value = "/entries/{id}")
    public ResponseEntity<?> updateEntry(@RequestBody Entries entry, @PathVariable(name = "id") int id) {
        if (entriesService.update(entry, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление клиента по id
     * @param id - идентификатор записи
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @DeleteMapping(value = "/entries/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable(name = "id") int id) {
        if (entriesService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Добавление клиента
     * @param entry - информация о записи
     * @return - Добавленный клиент
     */
    @PostMapping("/entries")
    public Entries createNewEntry(@RequestBody Entries entry) {
        return entriesService.create(entry);
    }
}
