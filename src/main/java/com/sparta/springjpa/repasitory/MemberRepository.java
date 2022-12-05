package com.sparta.springjpa.repasitory;

import com.sparta.springjpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
