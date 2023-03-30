package org.csu.petstoremanage.Controller;

import org.csu.petstoremanage.domain.SignOn;
import org.csu.petstoremanage.domain.User;
import org.csu.petstoremanage.service.SignonService;
import org.csu.petstoremanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SignonService signonService;

    // 显示用户列表
    @GetMapping
    public String listAccount(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("accounts", userList);
        return "account/list";
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            // 使用UserService更新用户信息
            userService.updateAccount(user);
            System.out.println(user.getFirstname());
            return new ResponseEntity<>("User updated successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/resetPwd")
    @ResponseBody
    public ResponseEntity<String> resetPwd(@RequestBody User user) {
        try {
            // 使用UserService更新重置密码后的用户信息

            String newPwd=user.getPassword();
            String suffixPwd="tiege";
            String primePwd=newPwd+suffixPwd;
            String md5Str = DigestUtils.md5DigestAsHex(primePwd.getBytes());

            userService.resetPassword(user.getId(),md5Str);

            SignOn signOn=new SignOn();
            signOn.setId(user.getId());
            signOn.setPassword(md5Str);

            signonService.resetPassword(user.getId(),md5Str);


            return new ResponseEntity<>("User updated successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 显示编辑用户页面
    @GetMapping("/{id}")
    public String editAccount(@PathVariable String id,Model model){
        User user = userService.getAccountById(id);
        model.addAttribute("account",user);
        return "/account/edit";
    }

    // 处理编辑用户请求
    @PostMapping("/{id}")
    public String updateAccount(@PathVariable String id, @ModelAttribute User user) {
        user.setId(id);
        userService.updateAccount(user);
        return "redirect:/account";
    }

    // 显示重置密码页面
    @GetMapping("/{id}/password")
    public String reset(@PathVariable String id, Model model) {
        User user = userService.getAccountById(id);
        model.addAttribute("account",user);
        return "/account/reset-password";
    }

    // 处理重置密码请求
    @PostMapping("/{id}/password")
    public String resetPassword(@PathVariable String id, @RequestParam String newPassword) {
        userService.resetPassword(id, newPassword);
        return "redirect:/account";
    }
}
