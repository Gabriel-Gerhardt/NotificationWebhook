package com.project.library.facade;

import com.project.library.contract.BookServiceContract;
import com.project.library.entities.Book;
import com.project.library.service.BookService;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class BookFacade implements BookServiceContract {
    private final BookService bookService;
    private final String PAYLOAD_URL = "http://manager:9000/webhook/payload";
    private final RestClient restClient;

    public BookFacade(BookService bookService, RestClient restClient) {
        this.bookService = bookService;
        this.restClient = restClient;
    }


    @Override
    public List<Book> findAll(String sortBy) {
        return bookService.findAll(sortBy);
    }

    @Override
    public void insertBook(Book book) {
        pushNotification(book);
        bookService.insertBook(book);

    }

    @Override
    public void insertBookList(List<Book> books) {
        pushNotification(books);
        bookService.insertBookList(books);

    }
    public void pushNotification(Object payload) {
        Map<String, Object> body = new HashMap<>();
        body.put("payload", payload);
        body.put("event", "create_book_list");
        try {
            restClient.post()
                    .uri(PAYLOAD_URL)
                    .contentType(APPLICATION_JSON)
                    .body(body)
                    .retrieve()
                    .toBodilessEntity();
            System.out.println(body);
        } catch (Exception e){
            throw new RuntimeException("Error pushing the payload " + e);
        }
    }
}
