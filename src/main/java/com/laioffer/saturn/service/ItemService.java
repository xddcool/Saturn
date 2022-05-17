package com.laioffer.saturn.service;



import com.laioffer.saturn.exception.CanNotAskOwnItemException;
import com.laioffer.saturn.exception.ItemDoesNotBelongException;
import com.laioffer.saturn.model.*;


import com.laioffer.saturn.repository.AskRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.laioffer.saturn.repository.ItemRepository;


import com.laioffer.saturn.exception.ItemNotExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private ImageStorageService imageStorageService;
    private AskRepository askRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, ImageStorageService imageStorageService, AskRepository askRepository) {
        this.itemRepository = itemRepository;
        this.imageStorageService = imageStorageService;
        this.askRepository = askRepository;
    }

    //Item delete
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(Long itemId, Principal principal) throws ItemNotExistException {

        // this api is for seller to delete his item


        if (!itemRepository.existsById(itemId)) {
            throw new ItemNotExistException("No such item in the database");
        }

        if (itemRepository.findItemByIdAndUsername(itemId, principal.getName()) == null) {
            throw new ItemDoesNotBelongException("You don't own this item");
        }

        Item item = itemRepository.findItemByIdAndUsername(itemId, principal.getName());


        itemRepository.deleteById(itemId);

    }

    //Item add
    public void add(Item item, MultipartFile[] images) {

        List<String> mediaLinks = Arrays.stream(images).parallel().map(image -> imageStorageService.save(image)).collect(Collectors.toList());
        List<ItemImage> stayImages = new ArrayList<>();
        for (String mediaLink : mediaLinks) {
            stayImages.add(new ItemImage(mediaLink, item));
        }
        item.setImages(stayImages);
        itemRepository.save(item);
    }

    //Item get

    public List<Item> get(Principal principal) {
        return itemRepository.findItemByUsername(principal.getName());
    }

    public List<Item> getAsk(Principal principal) {
        return itemRepository.findItemByUsernameAndStatus(principal.getName(), Status.ASKED);
    }

    //Item Change status to "ASK"
    public void ask(Long itemId, Principal principal) {

        Item item = itemRepository.findItemById(itemId);

        if (item == null) {
            throw new ItemNotExistException("No such item in the database");
        }

        if (item.getUsername().equals(principal.getName())) {
            throw new CanNotAskOwnItemException("You can't ask your own item");
        }




        Ask ask = new Ask.Builder().setAskBy(principal.getName())
                        .setItemId(itemId)
                        .build();

        askRepository.save(ask);
        //Ask newAsk = askRepository.findAskByItemIdAndAskBy(itemId, principal.getName());
        item.setStatus(Status.ASKED);
        //item.setAskId(newAsk.getId());
        itemRepository.save(item);
    }

    //Item Change status to "SOLD"
    public void sold(Long itemId, Principal principal) {

        Item item = itemRepository.findItemById(itemId);

        if (item == null) {
            throw new ItemNotExistException("No such item in the database");
        }

        if (!item.getUsername().equals(principal.getName())) {
            throw new CanNotAskOwnItemException("You can't sell your other people's item");
        }

        item.setStatus(Status.SOLD);
        itemRepository.save(item);
    }

    //Item edit
    public void edit(Item item, Long id, Principal principal) throws ItemNotExistException {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotExistException("No such item in the database");
        }


        Item oldItem = itemRepository.findItemByIdAndUsername(id, principal.getName());

        if (oldItem == null) {
            throw new ItemDoesNotBelongException("You don't own this item");
        }

        oldItem.setPrice(item.getPrice());
        oldItem.setDescription(item.getDescription());
        oldItem.setName(item.getName());
        itemRepository.save(oldItem);

    }



}
