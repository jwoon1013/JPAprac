package com.sparta.springjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Getter // Getter 생성
@Entity // Entity클래스임을 알림
@NoArgsConstructor // 기본생성자 생성
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Orders(Food food, Member member) {
        this.food = food;
        this.member = member;
    }

    @OneToMany(mappedBy = "food", fetch = FetchType.EAGER) // 음식 1개에 주문이 여러개 될 수 있어서 OnetoMany를 사용.
    private List<Orders> orders = new ArrayList<>();
}

// mappedBy : 연관관계의 주인을 지정해줌
// Food 테이블과 Orders 테이블이 @JoinColumen을 이용해 Join 되어있는데, food_id의 주인이 food 칼럼이란걸 mappedBy로 알려주는거라고 생각하면 됨.
// fetch는 지금은 이런게 있단 것만 알아두기.
