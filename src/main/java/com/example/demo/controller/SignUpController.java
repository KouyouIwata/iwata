package com.example.demo.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.UserModel;
import com.example.demo.service.SignUpService;
 
@Controller
public class SignUpController {
 
    @Autowired
    private SignUpService userService;
 
    @GetMapping("/")
    public String showTopPage(@ModelAttribute("user") UserModel user) {
        return "sign-up"; // ".html" 拡張子は省略
    }
    
    @GetMapping("/nikki")
    public String showInPage(@ModelAttribute("user") UserModel user) {
        return "nikki"; // ".html" 拡張子は省略
    }
 
    @PostMapping("/")
    public String registerUser(@ModelAttribute("user") UserModel user, RedirectAttributes redirectAttributes) {
        String result = userService.registerNewUser(user);
        if (result.equals("ユーザーが正常に登録されました")) {
            // 登録が成功した場合はリダイレクトする
            return "redirect:/nikki";
        } else {
            // 登録が失敗した場合はエラーメッセージを表示
            redirectAttributes.addFlashAttribute("errorMessage", result);
            return "redirect:/"; // リダイレクトしてもう一度トップページを表示
        }
    }
}