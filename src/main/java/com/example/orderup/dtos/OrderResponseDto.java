package com.example.orderup.dtos;

import java.time.Instant;

public class OrderResponseDtos {
    private Long id;
    private int quantity;
    private Instant createdAt;
    private String status;
    private ProductDto product;

    public OrderResponseDtos(Long id, int quantity, Instant createdAt, String status, ProductDto product) {
        this.id = id;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.status = status;
        this.product = product;
    }

    // Nested product DTO
    public static class ProductDtos {
        private Long id;
        private String name;
        private int stock;

        public ProductDtos(Long id, String name, int stock) {
            this.id = id;
            this.name = name;
            this.stock = stock;
        }

        public Long getId() { return id; }
        public String getName() { return name; }
        public int getStock() { return stock; }
    }

    public Long getId() { return id; }
    public int getQuantity() { return quantity; }
    public Instant getCreatedAt() { return createdAt; }
    public String getStatus() { return status; }
    public ProductDto getProduct() { return product; }
}
