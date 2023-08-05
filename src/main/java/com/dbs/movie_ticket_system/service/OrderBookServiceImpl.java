package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.OrderBook;
import com.dbs.movie_ticket_system.repository.OrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderBookServiceImpl implements OrderBookService{

    @Autowired
    private OrderBookRepository orderBookRepository;

    @Override
    public List<OrderBook> fetchOrderBookList() {
        return orderBookRepository.findAll();
    }

    @Override
    public OrderBook fetchOrderBookById(Long orderId) {
        return orderBookRepository.findById(orderId).get();
    }

    @Override
    public OrderBook saveOrderBook(OrderBook orderBook) {
        return orderBookRepository.save(orderBook);
    }

    public OrderBook updateOrderBook(Long orderBookId, OrderBook orderBook){
        OrderBook orderBookDB = orderBookRepository.findById(orderBookId).get();
        if(Objects.nonNull(orderBook.getProcessStage()) && !"".equalsIgnoreCase(String.valueOf(orderBook.getProcessStage()))){
            orderBookDB.setProcessStage(orderBook.getProcessStage());
        }
        return orderBookRepository.save(orderBookDB);
    }


    public void deleteOrderBookById(Long orderBookId){
        orderBookRepository.deleteById(orderBookId);
    }
}
