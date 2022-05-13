package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProductManager(Product item) {
        repository.add(item);
    }

    // метод возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                // itar+tab
                // копируем поэлементно
                //        for (int i = 0; i < items.length; i++) {
                //            tmp[i] = items[i];
                //        }
                System.arraycopy(result, 0, tmp, 0, result.length);
                // закладываем последним наш элемент
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строчку
        // return product.getName().contains(search);
        // return product.getId().contains(search);
        // return product.getCost().contains(search);

    }


}
