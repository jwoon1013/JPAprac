package com.sparta.springjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Getter 생성
@Entity // Entity클래스임을 알림
@NoArgsConstructor // 기본생성자 생성
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String foodName;
    @Column(nullable = false)
    private int price;

    public Food(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
    }
}
