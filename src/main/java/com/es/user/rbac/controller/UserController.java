package com.es.user.rbac.controller;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

   /* @Autowired
    private UserService userService;

   *//* @PostMapping(value = {"/users/oauth"}, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }*//*

    @GetMapping("/users/register")
    public User register(@RequestBody User user) {
        User register = userService.register(user);
        return register;
    }

    @GetMapping("/users/login")
    public Login login(@RequestBody User user) {
        Login login = userService.login(user);
        return login;
    }

    @GetMapping("/users")
    public List<User> getStudentList() {
        List<User> users = userService.findUsers();
        return users;
    }

    @PostMapping("/users")
    public User saveStudent(@RequestBody User user) {
        User addUser = userService.addUser(user);
        return addUser;
    }

    @DeleteMapping("/users/{name}")
    public Integer deleteUserByName(@PathVariable String name) {
        Integer deleteNum = userService.deleteUserByName(name);
        return deleteNum;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return updateUser;
    }

    @GetMapping("/users/list")
    public List<User> getStudentListByAgeAndSexAndHobbies() {
        List<User> userList = userService.findUserListByAgeAndSexAndHobbies();
        return userList;
    }*/

}



