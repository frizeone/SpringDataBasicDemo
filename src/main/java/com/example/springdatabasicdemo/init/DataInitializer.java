package com.example.springdatabasicdemo.init;

//import com.example.springdatabasicdemo.dtos.GroupDto;
//import com.example.springdatabasicdemo.dtos.StudentDto;
//import com.example.springdatabasicdemo.models.Group;
//import com.example.springdatabasicdemo.models.Student;
//import com.example.springdatabasicdemo.services.StudentService;
import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.enumPacage.Category;
import com.example.springdatabasicdemo.enumPacage.Engine;
import com.example.springdatabasicdemo.enumPacage.Role;
import com.example.springdatabasicdemo.enumPacage.Transmission;
import com.example.springdatabasicdemo.repositories.*;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private  BrandsRepository brandsRepository;
    private  ModelsRepository modelsRepository;
    private  UserRepository userRepository;
    private  OffersRepository offersRepository;
    private RolseRepository rolseRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(
            BrandsRepository brandsRepository,
            ModelsRepository modelsRepository,
            UserRepository userRepository,
            OffersRepository offersRepository,
            RolseRepository rolseRepository,
            PasswordEncoder passwordEncoder) {
        this.brandsRepository = brandsRepository;
        this.modelsRepository = modelsRepository;
        this.userRepository = userRepository;
        this.offersRepository = offersRepository;
        this.rolseRepository = rolseRepository;
        this.passwordEncoder= passwordEncoder;
    }

    @Autowired
    private BrandsService brandsService;

    @Autowired
    private ModelsService modelsService;

    @Autowired
    private UserService userService;

    @Autowired
    private OffersService offersService;

    @Autowired
    private RolesService rolesService;

    @Override
    public void run(String... args) throws Exception {
       seedData();

    }

    private void findAllModelsByBrands(BrandsDTO brandsDTO){
        modelsService.findModelsByBrands(brandsDTO).forEach(System.out::println);
    }

    private void findallModelsByCategory(Category category){
        modelsService.findModelsByCategory(category).forEach(System.out::println);
    }

    private void getAllOffersByUsers(UserDTO userDTO){
        offersService.getAllOffersByUsers(userDTO).forEach(System.out::println);
    }

    private void seedData() throws IOException {
        long now = System.currentTimeMillis();
        Date sqlDate = Date.valueOf("2023-12-05");
        Date modifid = Date.valueOf("2023-12-09");
        RolesDTO role1 = new RolesDTO(null,Role.USER);
        RolesDTO role2 = new RolesDTO(null,Role.ADMIN);
        RolesDTO roleUser = new RolesDTO(null, Role.USER);
        RolesDTO roleAdmin = new RolesDTO(null, Role.ADMIN);
        roleUser = rolesService.createdRoles(roleUser);
        roleAdmin = rolesService.createdRoles(roleAdmin);
        role1.setRole(Role.USER);
        role2.setRole(Role.ADMIN);
        role1 = rolesService.createdRoles(role1);
        role2 = rolesService.createdRoles(role2);

        UserDTO user1 = new UserDTO(null,"aaa", "123123", "Иван", "Плюх", true, roleUser , "/img/cls.jpg", sqlDate, sqlDate);

//        UserDTO user2 = new UserDTO(null, "bbb", "123123", "Вова", "Жух", true, roleAdmin , "/img/cls.jpg", sqlDate, sqlDate);


        user1 = userService.newUser(user1);
//        user2 = userService.newUser(user2);

        // Создание и сохранение объектов Brands
        BrandsDTO brand1 = new BrandsDTO(null, "Brand 1", sqlDate,sqlDate);
        BrandsDTO brand2 = new BrandsDTO(null, "Brand 2", sqlDate,sqlDate);
        BrandsDTO mercedesBenz = new BrandsDTO(null, "Mercedes-Benz", sqlDate,sqlDate);
        BrandsDTO audi = new BrandsDTO(null, "Audi", sqlDate,sqlDate);
        BrandsDTO bmw = new BrandsDTO(null, "BMW", sqlDate,sqlDate);
        mercedesBenz = brandsService.addNewBrand(mercedesBenz);
        bmw = brandsService.addNewBrand(bmw);
        audi = brandsService.addNewBrand(audi);
//        brand1 = brandsService.addNewBrand(brand1);
//        brand2 = brandsService.addNewBrand(brand2);

//        brandsRepository.save(brand1);
//        brandsRepository.save(brand2);


        // Создание и сохранение объектов Models
        ModelsDTO model1 = new ModelsDTO(null,"Model 1", Category.Car, "/img/cls.jpg", 2023, 2024, sqlDate,sqlDate, brand1);
        ModelsDTO model2 = new ModelsDTO(null,"Model 2", Category.Truck, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, brand2);
        ModelsDTO clsclass = new ModelsDTO(null,"CLS", Category.Car, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, mercedesBenz);
        ModelsDTO sclass = new ModelsDTO(null,"S-CLASS CABRIO", Category.Car, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, mercedesBenz);
        ModelsDTO eclass = new ModelsDTO(null,"E-CLASS", Category.Car, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, mercedesBenz);
        ModelsDTO ieight = new ModelsDTO(null,"I-8", Category.Car, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, bmw);
        ModelsDTO ieight1 = new ModelsDTO(null,"I-8", Category.Car, "/img/cls.jpg", 2024, 2026, sqlDate,sqlDate, bmw);
        ModelsDTO ieight2 = new ModelsDTO(null,"I-8", Category.Car, "/img/cls.jpg", 2025, 2027, sqlDate,sqlDate, bmw);
        ModelsDTO mfive = new ModelsDTO(null,"M-5 COMPETITION", Category.Car, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, bmw);
        ModelsDTO rssix = new ModelsDTO(null,"R-6 AVANT", Category.Car, "/img/cls.jpg", 2023, 2025, sqlDate,sqlDate, audi);
//        model1.setCategory(Category.Car);
//        model2.setCategory(Category.Truck);
//        model1 = modelsService.addModels(model1);
//        model2 = modelsService.addModels(model2);
        clsclass = modelsService.addModels(clsclass);
        sclass = modelsService.addModels(sclass);
        eclass = modelsService.addModels(eclass);
        ieight = modelsService.addModels(ieight);
        ieight1 = modelsService.addModels(ieight1);
        ieight2 = modelsService.addModels(ieight2);
        mfive = modelsService.addModels(mfive);
        rssix = modelsService.addModels(rssix);

//        modelsRepository.save(model1);
//        modelsRepository.save(model2);


//
//        rolseRepository.save(role1);
//        rolseRepository.save(role2);

        // Создание и сохранение объектов Users





        // Создание и сохранение объектов Offers

        OffersDTO offers1 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,clsclass,user1);
//        OffersDTO offers2 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,?clsclass,user2);
        OffersDTO offers3 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,clsclass,user1);
//        OffersDTO offers4 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,clsclass,user2);
        OffersDTO offers5 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,clsclass,user1);
//        OffersDTO offers6 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,mfive,user2);
        OffersDTO offers7 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,mfive,user1);
//        OffersDTO offers8 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,mfive,user2);
        OffersDTO offers9 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,clsclass,user1);
//        OffersDTO offers10 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,sclass,user2);
        OffersDTO offers11 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,clsclass,user1);
//        OffersDTO offers12 = new OffersDTO(null, "Offer 1 descriotion", Engine.ELECTRIC, "/img/cls.jpg", 1000, 1, Transmission.AUTOMATIC, sqlDate,sqlDate,sqlDate,rssix,user2);



        offers1 = offersService.newOffers(offers1);
//        offers2 = offersService.newOffers(offers2);
        offers3 = offersService.newOffers(offers3);
//        offers4 = offersService.newOffers(offers4);
        offers5 = offersService.newOffers(offers5);
//        offers6 = offersService.newOffers(offers6);
        offers7 = offersService.newOffers(offers7);
//        offers8 = offersService.newOffers(offers8);
        offers9 = offersService.newOffers(offers9);
//        offers10 = offersService.newOffers(offers10);
        offers11 = offersService.newOffers(offers11);
//        offers12 = offersService.newOffers(offers12);





//        findAllModelsByBrands(brand1);
//        findallModelsByCategory(Category.Car);
//        getAllOffersByUsers(user1);

//        long now = System.currentTimeMillis();
//        Date sqlDate = Date.valueOf("2023-12-05");

        // Заполнение Roles
//        RolesDTO roleUser = new RolesDTO(null, Role.User);
//        RolesDTO roleAdmin = new RolesDTO(null, Role.Admin);
//        roleUser = rolesService.createdRoles(roleUser);
//        roleAdmin = rolesService.createdRoles(roleAdmin);

        // Заполнение Users
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
//            models.add(modelsService.addModels(model));
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

    }
}




