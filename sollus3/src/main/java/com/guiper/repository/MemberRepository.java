package com.guiper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.guiper.entities.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {

    List<Member> findByLastName(String lastName);

}