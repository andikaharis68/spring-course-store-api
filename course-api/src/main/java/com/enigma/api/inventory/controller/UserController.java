package com.enigma.api.inventory.controller;

import com.enigma.api.inventory.entities.User;
import com.enigma.api.inventory.models.ResponsMessage;
import com.enigma.api.inventory.models.UserModel;
import com.enigma.api.inventory.repositories.UserRepository;
import com.enigma.api.inventory.services.Impl.UserDetailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.NoSuchAlgorithmException;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserDetailServiceImpl service;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    ModelMapper modelMapper;

    final private UserRepository userInfoRepository;

    public UserController(UserRepository userRepository) {
        this.userInfoRepository = userRepository;
    }

    @PostMapping()
    public ResponsMessage create(@RequestBody UserModel model) throws NoSuchAlgorithmException {
        User newUser = new User();
        newUser.setUsername(model.getUsername());
        newUser.setPassword(bcryptEncoder.encode(model.getPassword()));
        newUser.setFullname(model.getFullname());
        newUser.setEmail(model.getEmail());
        newUser.setAddress(model.getAddress());
        User entity = modelMapper.map(newUser, User.class);
        entity = service.save(entity);
        UserModel data = modelMapper.map(entity, UserModel.class);
        return ResponsMessage.success(data);
    }
}