package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);


    @Test
    //успешность добавления элемента
    public void theSuccessOfAddingAnElement() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");

        repository.add(product_1);
        repository.add(product_2);
        repository.add(product_3);
        repository.add(product_4);
        repository.add(product_5);
        repository.add(product_6);
        repository.add(product_7);
        repository.add(product_8);

        assertThrows(AlreadyExistsException.class, () -> {
            repository.add(product_3);
        });
    }


    @Test
    // удалить не существующий id
    public void deleteNonExistentId() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }


    @Test
    // удалить по идентификатору относительно ограничения
    public void deleteByIdRelativeToRestriction() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");

        repository.add(product_1);
        repository.add(product_2);
        repository.add(product_3);
        repository.add(product_4);
        repository.add(product_5);
        repository.add(product_6);
        repository.add(product_7);
        repository.add(product_8);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(100);
        });
    }


}