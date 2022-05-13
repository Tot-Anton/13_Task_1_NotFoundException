package ru.netology.repository;

import ru.netology.domain.AlreadyExistsException;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] items = new Product[0];

    // обратить внимание на item, а не items
    public void add(Product item) {
        // //вызывайте метод findById
        int id = item.getId();
        if (findById(id) == null) {

            // создаём новый массив
            int length = items.length + 1;
            Product[] tmp = new Product[length];
            // itar+tab
            // копируем поэлементно
            //        for (int i = 0; i < items.length; i++) {
            //            tmp[i] = items[i];
            //        }
            System.arraycopy(items, 0, tmp, 0, items.length);
            // закладываем последним наш элемент
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            items = tmp;
        } else {
            throw new AlreadyExistsException(id);
        }

    }

    // удаление по id
    public void removeById(int id) {
        //вызывайте метод findById
        if (findById(id) != null) {
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        } else {
            throw new NotFoundException(id);
        }
    }

    // метод findById, предназначенный для поиска товара в репозитории по его id
    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public Product[] findAll() {
        return items;
    }


}

