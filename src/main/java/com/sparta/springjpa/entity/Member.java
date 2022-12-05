package com.sparta.springjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter // Getter 생성
@Entity // Entity클래스임을 알림
@NoArgsConstructor // 기본생성자 생성
public class Member {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) // memberName의 값은 null이 될 수 없음
    private String memberName;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER) // mappedBy연관관계의 주인이 누군지 생각해보기
    private List<Orders> orders = new ArrayList<>();

    public Member(String memberName) {
        this.memberName = memberName;
    }
}
