package com.apple.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, int price, String writer) {
        var item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        item.setWriter(writer);
        itemRepository.save(item);
    }

    public void editItem(long id, String title, int price) {
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }
}
