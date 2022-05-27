package com.laioffer.saturn.service;

import com.laioffer.saturn.exception.AskDoesNotBelongException;
import com.laioffer.saturn.exception.AskNotExistException;
import com.laioffer.saturn.exception.ItemDoesNotBelongException;
import com.laioffer.saturn.exception.ItemNotExistException;
import com.laioffer.saturn.model.Ask;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.Status;
import com.laioffer.saturn.repository.AskRepository;
import com.laioffer.saturn.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AskService {

    private AskRepository askRepository;
    private ItemRepository itemRepository;

    @Autowired
    public AskService(AskRepository askRepository, ItemRepository itemRepository) {
        this.askRepository = askRepository;
        this.itemRepository = itemRepository;

    }

    public List<Item> get(Principal principal) {

        return  askRepository.findItemByAskBy(principal.getName());
    }

    public void delete(Long askId, Principal principal) throws ItemNotExistException {



        if (!askRepository.existsById(askId)) {
            throw new AskNotExistException("No such ask requests in the database");
        }
        List<Ask> asks = askRepository.findAskByAskBy(principal.getName());
        Ask ask = askRepository.getById(askId);
        Item item = askRepository.findItemByAsk(askId);

        if (asks.contains(ask)) {
            askRepository.deleteById(askId);
        } else {
            throw new AskDoesNotBelongException("You can only remove your own ask requests!");
        }

        if (askRepository.findAskByItem(item).isEmpty()) {
            item.setStatus(Status.FOR_SALE);
            itemRepository.save(item);
        }

    }
}
