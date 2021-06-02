package com.example.demo.shares;

import com.example.demo.clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Сервис для {@link Shares}
 */
@Service
public class SharesServiceImpl implements SharesService {

    @Autowired
    private SharesRepo sharesRepo;

    /**
     * Создание акции
     * @param share - информация об акции
     * @return - созданная акция
     */
    @Override
    public Shares create(Shares share) {
        return sharesRepo.save(share);
    }

    /**
     * Получает список всех акций
     * @return - возвращает список акций
     */
    @Override
    public List<Shares> readAll() {
        return sharesRepo.findAll();
    }

    /**
     * Получение акции
     * @param id - идентификатор акции
     * @return - возвращает одну акцию по id; null, если акция не найден
     */
    @Override
    public Shares read(long id) {
        return sharesRepo.findById(id).orElse(null);
    }

    /**
     * Изменение акции - информация об акции
     * @param id - идентификатор акции
     * @return - boolean
     */
    @Override
    public boolean update(Shares share, long id) {
        if (read(id) != null) {
            Shares updatedShare = new Shares();
            updatedShare.setId(id);
            updatedShare.setCoefficient(share.getCoefficient());
            updatedShare.setConditions(share.getConditions());
            updatedShare.setEnd_date(share.getEnd_date());
            updatedShare.setStart_date(share.getStart_date());
            updatedShare.setName(share.getName());

            sharesRepo.save(updatedShare);
            return true;
        }

        return false;
    }

    /**
     * Удаление акции
     * @param id - идентификатор акции
     * @return - boolean
     */
    @Override
    public boolean delete(long id) {
        if (read(id) != null) {
            sharesRepo.deleteById(id);
            return true;
        }

        return false;
    }
}
