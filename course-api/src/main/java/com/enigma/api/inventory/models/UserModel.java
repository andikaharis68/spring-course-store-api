package com.enigma.api.inventory.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserModel {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @Size(min = 1, max = 100)
    private String fullname;

    @NotBlank
    @Size(min = 1, max = 100)
    private String email;

    @NotBlank
    @Size(min = 1, max = 100)
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
