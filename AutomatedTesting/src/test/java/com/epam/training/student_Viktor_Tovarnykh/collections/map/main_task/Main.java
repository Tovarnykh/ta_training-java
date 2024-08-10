package com.epam.training.student_Viktor_Tovarnykh.collections.map.main_task;

import com.epam.training.student_viktor_tovarnykh.collections.map.main_task.Book;
import com.epam.training.student_viktor_tovarnykh.collections.map.main_task.BooksCatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        BooksCatalog catalog = new BooksCatalog(Util.getData("src/main/resources/data.csv"));
        System.out.println(catalog);
        System.out.println(catalog.getAllAuthors());
        System.out.println(catalog.findBooksByGenre("historical"));
        System.out.println(catalog.findAuthorsByBook(new Book("Twenty Years After",
                List.of("adventure"), new BigDecimal("286.02"))));
        System.out.println(catalog.findAuthorsByBookTitle("tw"));
    }
}
