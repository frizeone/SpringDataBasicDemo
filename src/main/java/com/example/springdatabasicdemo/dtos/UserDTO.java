package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enumPacage.Role;
import jakarta.validation.constraints.*;
import java.sql.Date;
import java.util.UUID;

public class UserDTO {

    private UUID id;

    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()_+\\-=<>?]*$", message = "Имя пользователя должно содержать только буквы, цифры и некоторые специальные символы")
    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String username;

    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()_+\\-=<>?]*$", message = "Пароль должен содержать только буквы, цифры и некоторые специальные символы")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    @Pattern(regexp = "^[А-Яа-я]*$", message = "First name must contain only Russian characters")
    @NotBlank(message = "Имя и фамилия не могут быть пустыми")
    private String first_name;

    @Pattern(regexp = "^[А-Яа-я]*$", message = "Last name must contain only Russian characters")
    @NotBlank(message = "Фамилия не может быть пустой")
    private String last_name;

    @NotNull(message = "is_active не может быть null")
    private Boolean is_active;

    @NotNull(message = "Роли не могут быть нулевыми")
    private RolesDTO roles;

    @NotBlank(message = "URL-адрес изображения не может быть пустым")
    private String image_url;

    @NotNull(message = "Дата создания не может быть равна null")
    @PastOrPresent(message = "Дата создания должна быть в прошлом или настоящем")
    private Date created;

    @NotNull(message = "Измененная дата не может быть равна null")
    @PastOrPresent(message = "Дата модификации должна быть в прошлом или настоящем")
    private Date modified;




    public UserDTO() {
    }

    public UserDTO(UUID id, String username, String password, String first_name, String last_name, Boolean is_active, RolesDTO roles, String image_url, Date created, Date modified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.is_active = is_active;
        this.roles = roles;
        this.image_url = image_url;
        this.created = created;
        this.modified = modified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public RolesDTO getRoles() {
        return roles;
    }

    public void setRoles(RolesDTO roles) {
        this.roles = roles;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModifited() {
        return modified;
    }

    public void setModifited(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "username='" + username + ", password='" + password +  ", firsName='" + first_name +  ", lastName='" + last_name + ", isActive=" + is_active + ", role=" + roles + ", imageUrl='" + image_url + ", created=" + created + ", modified=" + modified + '}';
    }
}
