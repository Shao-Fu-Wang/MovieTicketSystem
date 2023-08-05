package com.dbs.movie_ticket_system.controller;

import com.dbs.movie_ticket_system.entity.Customer;
import com.dbs.movie_ticket_system.entity.Movie;
import com.dbs.movie_ticket_system.entity.OrderBook;
import com.dbs.movie_ticket_system.service.CustomerService;
import com.dbs.movie_ticket_system.service.MovieService;
import com.dbs.movie_ticket_system.service.OrderBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class OrderBookController {
    @Autowired
    private OrderBookService orderBookService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MovieService movieService;
    private final Logger LOGGER = LoggerFactory.getLogger(OrderBookController.class);

    @GetMapping("/orderbooks")
    public List<OrderBook> fetchOrderBookList() {
        LOGGER.info("fetched");
        return orderBookService.fetchOrderBookList();
    }
    @PostMapping("/orderbooks/{customer_name}/{movie_name}")
    public OrderBook saveOrderBook(@PathVariable("customer_name") String customerName, @PathVariable("movie_name") String movieName){
        Customer customer = customerService.fetchCustomerByName(customerName);
        Movie movie = movieService.fetchMovieByName(movieName);
        OrderBook orderBook = OrderBook.builder().processStage(0).customer(customer).movie(movie).build();
        LOGGER.info("uploading orderbook");
        return orderBookService.saveOrderBook(orderBook);
    }
    @PostMapping("/orderbooks/process/{id}")
    public OrderBook processOrderBook(@PathVariable("id") Long id){
        OrderBook orderBook = orderBookService.fetchOrderBookById(id);
        orderBook.setOrderBookId(orderBook.getOrderBookId()+1);
        LOGGER.info("processing orderbook");
        return orderBookService.updateOrderBook(id, orderBook);
    }
    @DeleteMapping("/orderbooks/{id}")
    public String deleteOrderById(@PathVariable("id") Long orderId) {
        orderBookService.deleteOrderBookById(orderId);
        LOGGER.info("deleting orderbook");
        return "Order id: " + orderId + " deleted Successfully";
    }
}
