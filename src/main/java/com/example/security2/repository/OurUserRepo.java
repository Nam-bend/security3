package com.example.security2.repository;

import com.example.security2.entity.OurUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  OurUserRepo extends JpaRepository<OurUser,Integer> {
    Optional<OurUser> findByEmail(String email);


}
