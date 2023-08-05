package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.OrderBook;

import java.util.List;

public interface OrderBookService {
    public List<OrderBook> fetchOrderBookList();
    public OrderBook fetchOrderBookById(Long orderId);
    public OrderBook saveOrderBook(OrderBook orderBook);

    public OrderBook updateOrderBook(Long orderBookId, OrderBook orderBook);

    public void deleteOrderBookById(Long orderBookId);
}
