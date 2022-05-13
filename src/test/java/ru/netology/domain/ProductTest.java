package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @Test
    // добавления элемента два одинаковых элемента
    public void addingAnElementTwoIdenticalElements() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(1, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");

        repository.add(product_1);
        repository.add(product_3);


        assertThrows(AlreadyExistsException.class, () -> {
            repository.add(product_1);
        });
    }

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
    // удалить по идентификатору относительно ограничения, с пустым полем
    public void deleteAnEmptyFieldByIdRelativeToTheRestriction() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(400);
        });
    }

  //delete an Empty field By Id Relative to the Restriction
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
            repository.removeById(400);
        });
    }


    @Test
    //сохраните выбранные товар методом репозитория
    public void saveTheSelectedGoodsUsingTheRepositoryMethod() {

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

        Product[] expected = new Product[]{product_1, product_2, product_3, product_4, product_5, product_6, product_7, product_8};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    //сохранение конкретного товара
    public void savingSpecificProduct() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");

        repository.add(product_5);

        Product[] expected = new Product[]{product_5};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    //добавление товара к сохранённому
    public void addingAnItemToSavedOne() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");


        repository.add(product_3);
        repository.add(product_7);


        Product[] expected = new Product[]{product_3, product_7};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    //сохраните выбранные товар методом менеджера
    public void saveTheSelectedGoodsUsingTheManagerMethod() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");

        manager.addProductManager(product_1);
        manager.addProductManager(product_2);
        manager.addProductManager(product_3);
        manager.addProductManager(product_4);
        manager.addProductManager(product_5);
        manager.addProductManager(product_6);
        manager.addProductManager(product_7);
        manager.addProductManager(product_8);

        Product[] expected = new Product[]{product_1, product_2, product_3, product_4, product_5, product_6, product_7, product_8};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    //удаление по id
    public void deleteByIdFromTheList() {

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
        repository.removeById(4);

        Product[] expected = new Product[]{product_1, product_2, product_3, product_5, product_6, product_7, product_8};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    //поиск по слову
    public void searchByWord() {

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

        Product[] expected = new Product[]{product_1, product_4};
        Product[] actual = manager.searchBy("Собрание сочинений");

        assertArrayEquals(expected, actual);
    }


    @Test
    //поиск по слову, при отсутствии в списке
    public void searchByWordWhenNotInTheList() {

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
        //repository.add(product_8);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("HUAWEI");

        assertArrayEquals(expected, actual);
    }


    @Test
    //поиск пустого поля
    public void searchForAnEmptyField() {

        Book product_1 = new Book(1, "Собрание сочинений", 555, "А.С.Пушкин");
        Book product_2 = new Book(2, "Толковый словарь", 2000, "В.И.Даль");
        Book product_3 = new Book(3, "Народные русские сказки", 1400, "А.Н.Афанасьева");
        Book product_4 = new Book(4, "Собрание сочинений", 2000, "К.Д.Ушинский");
        Smartphone product_5 = new Smartphone(5, "Redmi 9A", 9999, "Xiaomi");
        Smartphone product_6 = new Smartphone(6, "Galaxy A12", 13999, "Samsung");
        Smartphone product_7 = new Smartphone(7, "8i", 16499, "realme");
        Smartphone product_8 = new Smartphone(8, "nova 9 SE", 29999, "HUAWEI");

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("");

        assertArrayEquals(expected, actual);
    }


}