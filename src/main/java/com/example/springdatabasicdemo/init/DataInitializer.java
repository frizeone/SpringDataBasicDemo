//package com.example.springdatabasicdemo.init;
//
////import com.example.springdatabasicdemo.dtos.GroupDto;
////import com.example.springdatabasicdemo.dtos.StudentDto;
////import com.example.springdatabasicdemo.models.Group;
////import com.example.springdatabasicdemo.models.Student;
////import com.example.springdatabasicdemo.services.StudentService;
//import com.example.springdatabasicdemo.dtos.*;
//import com.example.springdatabasicdemo.enumPacage.Category;
//import com.example.springdatabasicdemo.enumPacage.Engine;
//import com.example.springdatabasicdemo.enumPacage.Role;
//import com.example.springdatabasicdemo.enumPacage.Transmission;
//import com.example.springdatabasicdemo.models.*;
//import com.example.springdatabasicdemo.repositories.*;
//import com.example.springdatabasicdemo.services.*;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Set;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//    private  BrandsRepository brandsRepository;
//    private  ModelsRepository modelsRepository;
//    private  UserRepository userRepository;
//    private  OffersRepository offersRepository;
//    private RolseRepository rolseRepository;
//
//    @Autowired
//    public DataInitializer(
//            BrandsRepository brandsRepository,
//            ModelsRepository modelsRepository,
//            UserRepository userRepository,
//            OffersRepository offersRepository,
//            RolseRepository rolseRepository) {
//        this.brandsRepository = brandsRepository;
//        this.modelsRepository = modelsRepository;
//        this.userRepository = userRepository;
//        this.offersRepository = offersRepository;
//        this.rolseRepository = rolseRepository;
//    }
//
//    @Autowired
//    private BrandsService brandsService;
//
//    @Autowired
//    private ModelsService modelsService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private OffersService offersService;
//
//    @Autowired
//    private RolesService rolesService;
//
//    @Override
//    public void run(String... args) throws Exception {
//       seedData();
//
//    }
//
//    private void findAllModelsByBrands(BrandsDTO brandsDTO){
//        modelsService.findModelsByBrands(brandsDTO).forEach(System.out::println);
//    }
//
//    private void findallModelsByCategory(Category category){
//        modelsService.findModelsByCategory(category).forEach(System.out::println);
//    }
//
//    private void getAllOffersByUsers(UserDTO userDTO){
//        offersService.getAllOffersByUsers(userDTO).forEach(System.out::println);
//    }
//
//    private void seedData() throws IOException {
//        long now = System.currentTimeMillis();
//        Date sqlDate = Date.valueOf("2023-12-05");
//        RolesDTO role1 = new RolesDTO(null,Role.User);
//        RolesDTO role2 = new RolesDTO(null,Role.Admin);
//        role1.setRole(Role.User);
//        role2.setRole(Role.Admin);
//        role1 = rolesService.createdRoles(role1);
//        role2 = rolesService.createdRoles(role2);
//
//        UserDTO user1 = new UserDTO(null,"aaa", "123123", "Иван", "Плюх", true, role1 , "sdfoisdv", sqlDate, sqlDate);
//
//        UserDTO user2 = new UserDTO(null, "bbb", "123123", "Вова", "Жух", true, role2 , "sdfoisdv", sqlDate, sqlDate);
//
//
//        user1 = userService.newUser(user1);
//        user2 = userService.newUser(user2);
//
//        // Создание и сохранение объектов Brands
//        BrandsDTO brand1 = new BrandsDTO(null, "Brand 1", sqlDate,sqlDate);
//        BrandsDTO brand2 = new BrandsDTO(null, "Brand 2", sqlDate,sqlDate);
//
//        brand1 = brandsService.addNewBrand(brand1);
//        brand2 = brandsService.addNewBrand(brand2);
//
////        brandsRepository.save(brand1);
////        brandsRepository.save(brand2);
//
//
//        // Создание и сохранение объектов Models
//        ModelsDTO model1 = new ModelsDTO(null,"Model 1", Category.Car, "image_url_1", 2023, 2024, sqlDate,sqlDate, brand1);
//        ModelsDTO model2 = new ModelsDTO(null,"Model 2", Category.Truck, "image_url_2", 2023, 2025, sqlDate,sqlDate, brand2);
//
//        model1.setCategory(Category.Car);
//        model2.setCategory(Category.Truck);
//        model1 = modelsService.addNewModels(model1);
//        model2 = modelsService.addNewModels(model2);
//
////        modelsRepository.save(model1);
////        modelsRepository.save(model2);
//
//
////
////        rolseRepository.save(role1);
////        rolseRepository.save(role2);
//
//        // Создание и сохранение объектов Users
//
//
//
//
//
//        // Создание и сохранение объектов Offers
//
//        OffersDTO offers1 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "url", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,model1,user1);
//        OffersDTO offers2 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "url", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,model1,user2);
//
//        offers1.setEngine(Engine.ELECTRIC);
//        offers1.setTransmission(Transmission.AUTOMATIC);
//        offers2.setEngine(Engine.ELECTRIC);
//        offers2.setTransmission(Transmission.AUTOMATIC);
//
//        offers1 = offersService.newOffers(offers1);
//        offers2 = offersService.newOffers(offers2);
//
//
//
////        findAllModelsByBrands(brand1);
////        findallModelsByCategory(Category.Car);
////        getAllOffersByUsers(user1);
//
//
//    }
//}
//
//
//
//
