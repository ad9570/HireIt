package com.hire.it.repository;

import com.hire.it.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { //findAll(), save()
	
   @EntityGraph(attributePaths = "authorities") //쿼리 수행 시 Lazy조회 대신 Eager조회로 authorities 정보를 가져옴
   Optional<User> findOneWithAuthoritiesByUsername(String username); //username을 기준으로 user정보와 권한정보를 같이 가져옴
   
}
