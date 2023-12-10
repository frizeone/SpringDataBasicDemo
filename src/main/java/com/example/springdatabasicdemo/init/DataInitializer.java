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
//import com.example.springdatabasicdemo.repositories.*;
//import com.example.springdatabasicdemo.services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
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
//        Date modifid = Date.valueOf("2023-12-09");
//        RolesDTO role1 = new RolesDTO(null,Role.User);
//        RolesDTO role2 = new RolesDTO(null,Role.Admin);
//        role1.setRole(Role.User);
//        role2.setRole(Role.Admin);
//        role1 = rolesService.createdRoles(role1);
//        role2 = rolesService.createdRoles(role2);
//
//        UserDTO user1 = new UserDTO(null,"aaa", "123123", "Иван", "Плюх", true, role1 , "/img/cls.jpg", sqlDate, sqlDate);
//
//        UserDTO user2 = new UserDTO(null, "bbb", "123123", "Вова", "Жух", true, role2 , "/img/cls.jpg", sqlDate, sqlDate);
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
//        ModelsDTO model1 = new ModelsDTO(null,"Model 1", Category.Car, "/img/cls.jpg", 2023, 2024, sqlDate,sqlDate, brand1);
//        ModelsDTO model2 = new ModelsDTO(null,"Model 2", Category.Truck, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, brand2);
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
//        OffersDTO offers1 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,model1,user1);
//        OffersDTO offers2 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,model1,user2);
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
////        long now = System.currentTimeMillis();
////        Date sqlDate = Date.valueOf("2023-12-05");
//
//        // Заполнение Roles
//        RolesDTO roleUser = new RolesDTO(null, Role.User);
//        RolesDTO roleAdmin = new RolesDTO(null, Role.Admin);
//        roleUser = rolesService.createdRoles(roleUser);
//        roleAdmin = rolesService.createdRoles(roleAdmin);
//
//        // Заполнение Users
//        List<UserDTO> users = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            UserDTO user3 = new UserDTO(null,"aaa" + i, "123123" + i, "Иван", "Плюх", true, role1 , "/img/cls.jpg", sqlDate, modifid);
//            users.add(userService.newUser(user3));
//        }
//
//        // Заполнение Brands
//        List<BrandsDTO> brands = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            BrandsDTO brand = new BrandsDTO(null, "Brand " + i, sqlDate, sqlDate);
//            brands.add(brandsService.addNewBrand(brand));
//        }
//
//        // Заполнение Models
//        List<ModelsDTO> models = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            ModelsDTO model = new ModelsDTO(null, "Model " + i, Category.Car, "/img/cls.jpg",
//                    2023, 2024, sqlDate, sqlDate, brands.get(i % brands.size()));
//            model.setCategory(i % 2 == 0 ? Category.Car : Category.Truck);
//            models.add(modelsService.addNewModels(model));
//        }
//
//        // Заполнение Offers
//        List<OffersDTO> offers = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            OffersDTO offer = new OffersDTO(null, "Offer " + i + " description", Engine.ELECTRIC,
//                    "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate, sqlDate, sqlDate,
//                    models.get(i % models.size()), users.get(i % users.size()));
//            offer.setEngine(Engine.ELECTRIC);
//            offer.setTransmission(Transmission.AUTOMATIC);
//            offers.add(offersService.newOffers(offer));
//        }
//
//    }
//}
//
//
//
//
