package com.example.springdatabasicdemo.dtos;

import jakarta.validation.constraints.*;

import java.sql.Date;

public class RegisterDTO {


    private String username;


    private String password;


    private String confirmPassword;


    private String first_name;


    private String last_name;




//    private Boolean is_active;
//
//
//    private RolesDTO roles;
//
//
//    private String image_url;
//
//
//    private Date created;
//
//
//    private Date modified;


    public RegisterDTO(String username, String password, String confirmPassword, String first_name, String last_name) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public RegisterDTO() {

    }

//    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()_+\\-=<>?]*$", message = "Имя пользователя должно содержать только буквы, цифры и некоторые специальные символы")
    @NotEmpty(message = "Имя пользователя не может быть пустым")
    @Size(min = 5, max = 20)
    public String getUsername() {
        return username;
    }

//    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()_+\\-=<>?]*$", message = "Пароль должен содержать только буквы, цифры и некоторые специальные символы")
    @NotEmpty(message = "Пароль не может быть пустым")
    @Size(min = 5, max = 20)
    public String getPassword() {
        return password;
    }

//    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()_+\\-=<>?]*$", message = "Пароль должен содержать только буквы, цифры и некоторые специальные символы")
    @NotEmpty(message = "Пароль не может быть пустым")
    @Size(min = 5, max = 20)
    public String getConfirmPassword() {
        return confirmPassword;
    }

//    @Pattern(regexp = "^[А-Яа-я]*$", message = "First name must contain only Russian characters")
    @NotEmpty(message = "Имя и фамилия не могут быть пустыми")
    @Size(min = 5, max = 20)
    public String getFirst_name() {
        return first_name;
    }

//    @Pattern(regexp = "^[А-Яа-я]*$", message = "Last name must contain only Russian characters")
    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 5, max = 20)
    public String getLast_name() {
        return last_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    //    @NotNull(message = "is_active не может быть null")
//    public Boolean getIs_active() {
//        return is_active;
//    }
//
//    @NotNull(message = "Роли не могут быть нулевыми")
//    public void setIs_active(Boolean is_active) {
//        this.is_active = true;
//    }
//
//    @NotNull(message = "Роли не могут быть нулевыми")
//    public RolesDTO getRoles() {
//        return roles;
//    }
//
//    public void setRoles(RolesDTO roles) {
//        this.roles = roles;
//    }
//
//    @NotBlank(message = "URL-адрес изображения не может быть пустым")
//    public String getImage_url() {
//        return image_url;
//    }
//
//    @NotNull(message = "Дата создания не может быть равна null")
//    @PastOrPresent(message = "Дата создания должна быть в прошлом или настоящем")
//    public Date getCreated() {
//        return created;
//    }
//
//
//    @NotNull(message = "Измененная дата не может быть равна null")
//    @PastOrPresent(message = "Дата модификации должна быть в прошлом или настоящем")
//    public Date getModified() {
//        return modified;
//    }
//
//    public void setImage_url(String image_url) {
//        this.image_url = image_url;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    public void setModified(Date modified) {
//        this.modified = modified;
//    }


    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
