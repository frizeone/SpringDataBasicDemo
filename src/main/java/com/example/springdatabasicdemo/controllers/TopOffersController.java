package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class TopOffersController {
    private final OffersRepository offersRepository;
  //      Переделывать а то не робит
    @Autowired
    public TopOffersController(OffersRepository offersRepository) {
        this.offersRepository = offersRepository;
    }

    @GetMapping("/topModels")
    public String showTopModels(Model model) {
        Pageable pageable = (Pageable) PageRequest.of(0, 3); // Получить топ-3 записей
        List<Object[]> topModels = offersRepository.findTopModelsByOfferCount(pageable);

        // topModels содержит массивы Object[], где каждый массив содержит model.id и offerCount
        // Далее преобразуйте эти данные в формат, который вам нужен для представления
        // Например, создайте список DTO или передайте непосредственно в модель

         model.addAttribute("topModels", topModels);

        return "topModels";
    }

}
