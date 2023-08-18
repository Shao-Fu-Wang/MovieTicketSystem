# Movie Ticket System

This is a movie ticket system, practice for spring boot.

## Database Relationship, WIP

![DatabaseRelationship](https://github.com/Shao-Fu-Wang/MovieTicketSystem/assets/45915603/934905eb-d6f3-40eb-bfdc-97e3c9c5b88a)

## API Reference

### Customer

#### Get all customer

```http
  GET /customers
```

#### Get specific customer with id

```http
  GET /customers/{id}
```

#### Get specific customer with name

```http
  GET /customers/name/{name}
```
#### Upload new customer

```http
  POST /customers
```

```json
{
  "customerName": "Name",
  "customerMobileNumber": "0900000000",
  "customerPassword": "Password"
}
```
#### Update customer with id

```http
  PUT /customers/{id}
```

```json
{
  "customerName": "Name",
  "customerMobileNumber": "0900000000",
  "customerPassword": "Password"
}
```

#### Delete customer with id

```http
  DELETE /customers/{id}
```

### Movie

#### Get all movie

```http
  GET /movies
```

#### Get specific movie with name

```http
  GET /movies/name/{name}
```

#### Upload specific movie

```http
  POST /movies"
```
```json
{
    "movieName": "Name",
    "movieDatetime": "Date",
    "movieOnboard" : "False"
}
```

#### Update movie with id

```http
  PUT /movies/{id}
```

```json
{
  "movieName": "Name",
  "movieDatetime": "Date",
  "movieOnboard" : "False"
}
```

#### Ondeboard movie with id

```http
  PUT /movies/admin/ondeboard/{movie_name}
```

### Order

#### Get all orders

```http
  GET /orderbooks
```

#### Get specific order with customer and movie name

```http
  GET orderbooks/{customer_name}/{movie_name}
```

#### Process specific order stage

```http
  POST /orderbooks/process/{id}"
```

#### Delete order with id

```http
  DELETE /orderbooks/{id}
```

### Ticket Level

#### Get all ticket level stage

```http
  GET /ticketlevels
```

#### Get ticket level of specific movie

```http
  POST /ticketlevels/{movie_name}
 ```
```json
{
    "bronze": "10",
    "silver": "21",
    "gold": "312"
}
```


