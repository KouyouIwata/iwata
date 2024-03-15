package com.example.demo.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;


 
@Service
public class UserService {
 
    @Autowired
    private UserRepository userRepository;
 
    // ユーザーの認証を行うメソッド
    public String authenticateUser(String username, String password) {
        // ユーザー名を使ってユーザーを検索
        UserModel user = userRepository.findByUsername(username);
        if (user == null) {
            // ユーザーが存在しない場合は "ユーザーネームが違います" を返す
            return "ユーザーネームが違います";
        }
        // ユーザーが存在し、パスワードが一致しない場合は "パスワードが違います" を返す
        if (!user.getPassword().equals(password)) {
            return "パスワードが違います";
        }
        // 認証成功
        return "認証成功";
    }
}