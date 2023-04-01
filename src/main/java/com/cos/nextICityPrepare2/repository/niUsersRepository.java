package com.cos.nextICityPrepare2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.nextICityPrepare2.model.niUsers;

public interface niUsersRepository extends JpaRepository<niUsers, Integer> {
	// 회원찾기 할 때 쓰이는 것이다.
	Optional<niUsers> findByUsername(String username);

}
