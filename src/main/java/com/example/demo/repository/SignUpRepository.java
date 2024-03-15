package com.example.demo.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;
 
@Repository
public interface SignUpRepository extends JpaRepository<UserModel, Long> {
 
    // ユーザーネームの重複チェック
    boolean existsByUsername(String username);
 
    
}