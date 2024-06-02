package com.code.bug.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.code.bug.model.LoginUser;


@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long>{
	LoginUser findByUsername(String username);
}