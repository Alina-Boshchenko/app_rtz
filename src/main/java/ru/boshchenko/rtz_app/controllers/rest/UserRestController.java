package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.UserDto;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.findAll();
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("пришел запрос");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        if (userService.existsById(id)){
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        System.out.println(userDto.toString());
        System.out.println("user сохранен");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO посмотреть какой должен быть статус ответа
    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        if(userService.updateUser(id, userDto)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.updateUser(id, userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        if (!userService.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(id);
        return new ResponseEntity<>("It's ok delete product",HttpStatus.OK);
    }





}
