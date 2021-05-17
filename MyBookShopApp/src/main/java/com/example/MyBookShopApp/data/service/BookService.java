package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.dto.Book;
import com.example.MyBookShopApp.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();

    }

    //NEW BOOK SERVICE METHODS

    public List<Book> getBooksByAuthor(String authorName){
        return bookRepository.findBooksByAuthorFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return bookRepository.findBooksByPriceBetween(min,max);
    }

    public List <Book> getBookWithPrice(Integer price){
        return bookRepository.findBooksByPriceIs(price);
    }

    public List<Book> getBookWithMaxDiscount(){
        return bookRepository.getBookWithMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return bookRepository.getBestsellers();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBooksByTitleContaining(searchWord, nextPage);
    }

    public Page<Book> getPageOfRecentBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByPubDate(nextPage);
    }

    public Page<Book> getPageOfRecentBooksBetween(Integer offset, Integer limit, LocalDate fromdaterecent, LocalDate enddaterecent){
        Pageable nextPage = PageRequest.of(offset,limit);

        return bookRepository.findByPubDateBetweenOrderByPubDateDesc(nextPage,fromdaterecent,enddaterecent);
    }



//    public List<Book> getPageOfRecentBooks(){
//
//        return bookRepository.findBooksByPubDate();
//    }

}





