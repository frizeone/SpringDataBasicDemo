package com.example.springdatabasicdemo.controllers;




import com.example.springdatabasicdemo.dtos.RegisterDTO;
import com.example.springdatabasicdemo.enumPacage.Role;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.RolseRepository;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.services.impl.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/users")
public class AuthController {

    private static final Logger LOG = LogManager.getLogger(Controller.class);

    private AuthService authService;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RolseRepository rolseRepository;

    @Autowired
    public AuthController(AuthService authService, PasswordEncoder passwordEncoder, UserRepository userRepository, RolseRepository rolseRepository) {
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.rolseRepository = rolseRepository;
    }

    @ModelAttribute("userRegistrationDto")
    public RegisterDTO initForm() {
        return new RegisterDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid RegisterDTO userRegistrationDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);
//
//            return "redirect:/users/register";
//        }

        Users user = new Users(
                true,
                userRegistrationDto.getFirst_name(),
                userRegistrationDto.getLast_name(),
                passwordEncoder.encode(userRegistrationDto.getPassword()),
                userRegistrationDto.getUsername()


        );


        var userRole = rolseRepository.findRolesByRole(Role.USER).orElseThrow();
        user.setRoles(List.of(userRole));


        this.userRepository.save(user);

        System.out.println("--------------getPassword--------------- " + userRegistrationDto.getPassword());
        System.out.println("--------------getUsername--------------- " + userRegistrationDto.getUsername());
        System.out.println("--------------getFirst_name--------------- " + userRegistrationDto.getFirst_name());
        System.out.println("--------------getLast_name--------------- " + userRegistrationDto.getLast_name());

//        try {
            this.authService.register(userRegistrationDto);
            return "redirect:/login";
//        }catch (RuntimeException e) {
//            redirectAttributes.addFlashAttribute("error", e.getMessage());
//            return "redirect:/users/register";
//        }

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);

        return "redirect:/users/login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String username = principal.getName();
        Users user = authService.getUser(username);
        model.addAttribute("user", user);

        return "profile";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Ручной выход пользователя
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/"; // Перенаправление на главную страницу или другую страницу после выхода
    }
}