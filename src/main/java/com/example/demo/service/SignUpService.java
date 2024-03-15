
package com.example.demo.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.SignUpRepository;
 
@Service

public class SignUpService {
 
    @Autowired

    private SignUpRepository userRepository;
 
    // 新規登録機能のメソッド

    public String registerNewUser(UserModel user) {

        // ユーザーネームの重複チェック

        if (userRepository.existsByUsername(user.getUsername())) {

            return "ユーザーネームが既に使用されています";

        }

      
        // いずれも重複していない場合は新規登録を行う

        userRepository.save(user);

        return "ユーザーが正常に登録されました";

    }

}
