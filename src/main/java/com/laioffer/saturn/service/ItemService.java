package com.laioffer.saturn.service;



import com.laioffer.saturn.model.ItemImage;
import com.laioffer.saturn.model.User;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.laioffer.saturn.repository.ItemRepository;


import com.laioffer.saturn.exception.ItemNotExistException;

import com.laioffer.saturn.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private ImageStorageService imageStorageService;

    @Autowired
    public ItemService(ItemRepository itemRepository, ImageStorageService imageStorageService) {
        this.itemRepository = itemRepository;
        this.imageStorageService = imageStorageService;
    }

    //Item delete
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(Long itemId) throws ItemNotExistException {

        // this api is for seller to delete his item


        if (!itemRepository.existsById(itemId)) {
            throw new ItemNotExistException("No such item in the database");
        }
        Item item = itemRepository.getById(itemId);

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

    public List<Item> get(User user) {
        return itemRepository.findItemByUsername(user.getUsername());
    }

    //Item edit
    public void edit(Item item, Long id) throws ItemNotExistException {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotExistException("No such item in the database");
        }

        Item oldItem = itemRepository.getById(id);
        oldItem.setPrice(item.getPrice());
        oldItem.setDescription(item.getDescription());
        oldItem.setName(item.getName());
        itemRepository.save(oldItem);

    }



}
