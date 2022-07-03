package com.example.musodza.Tatenda.controller;

import com.example.musodza.Tatenda.model.UserModel;
import com.example.musodza.Tatenda.repository.UserRepository;
import javafx.beans.binding.ObjectBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "createuser",method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestParam String fname, @RequestParam String lname){
        UserModel userModel =new UserModel(fname,lname);
        userRepository.save(userModel);
        return new ResponseEntity<Object>("saved", HttpStatus.OK);
    }

    @RequestMapping(value = "getusers",method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(){
        List<UserModel> users = userRepository.findAll();
        if (users==null){
            return new ResponseEntity<Object>("no user found",HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(users,HttpStatus.OK);
        }
    }
    @RequestMapping(value = "getuser",method = RequestMethod.POST)
    public ResponseEntity<Object> getUser(@RequestParam int id){
        UserModel user= userRepository.findById(id);
        if (user==null){
            return new ResponseEntity<Object>("user not found",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Object>(user,HttpStatus.OK);
        }
    }
    @RequestMapping(value = "deleteuser",method = RequestMethod.POST)
    public ResponseEntity<Object> deleteUser(@RequestParam int id){
        UserModel user=userRepository.findById(id);
        if (user==null){
            return new ResponseEntity<Object>("no user found",HttpStatus.OK);
        }
        else {
            userRepository.delete(user);
            return new ResponseEntity<Object>("deleted",HttpStatus.OK);
        }
    }
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUser(@RequestParam int id,@RequestParam String fname, @RequestParam String lname){
        UserModel user =userRepository.findById(id);
        if (user==null){
            return new ResponseEntity<Object>("no user found",HttpStatus.OK);
        }
        else {
            user.setFname(fname);
            user.setLname(lname);
            userRepository.save(user);
            return new ResponseEntity<Object>("user updated",HttpStatus.OK);
        }
    }
}
