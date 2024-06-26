package com.example.buyer.product;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "product_tb")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;
    //재고
    @Column(nullable = false)
    private Integer qty;

    //이미지용 //파일 이름(파일 경로)
    @Column(nullable = false)
    private String imgFileName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Transient
    private Integer indexNumb;

    @Builder
    public Product(Integer id, String name, Integer price, Integer qty, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.createdAt = createdAt;
    }
}