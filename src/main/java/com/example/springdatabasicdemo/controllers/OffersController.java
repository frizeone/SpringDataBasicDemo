package com.example.springdatabasicdemo.controllers;


import com.example.springdatabasicdemo.dtos.BrandsDTO;
import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.dtos.OffersDTO;
import com.example.springdatabasicdemo.models.Offers;
import com.example.springdatabasicdemo.services.ModelsService;
import com.example.springdatabasicdemo.services.OffersService;
import com.example.springdatabasicdemo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Offers")
public class OffersController {


    private final OffersService offersService;

    private final ModelsService modelsService;

    private final UserService userService;

    public OffersController (OffersService offersService, ModelsService modelsService, UserService userService){
        this.offersService = offersService;
        this.modelsService = modelsService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllOffers(Model model){
        List<OffersDTO> offersDTOList = offersService.getAllOffers();
        model.addAttribute("offers", offersDTOList);
        return "Offers-all";
    }

    @GetMapping("/details/{id}")
    public String getDetailsOffers(@PathVariable("id") UUID uuid, Model model){
        model.addAttribute("offersDetails", offersService.getOfferById(uuid));
        return "Offers-details";
    }

    @GetMapping("/details/delete/{id}")
    public String deleteModels (@PathVariable("id") UUID uuid, Model model){
        offersService.deleteOffers(uuid);
        return "redirect:/Offers/all";
    }

    @GetMapping("/add")
    public String showCreateOfferForm(Model model) {

        model.addAttribute("availableModels", modelsService.getAllModels());
        model.addAttribute("availableUsers", userService.getAllUsers());
        model.addAttribute("AddOfferDto", new OffersDTO());


        return "offer-add";
    }


    @PostMapping("/offer/create")
    public String createOffer(@Valid OffersDTO offerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect:/offers/add";
        }
        offersService.newOffers(offerModel);

        return "redirect:/";
    }

    @PostMapping("offers/add")
    public ResponseEntity<OffersDTO> addNewOffers(@RequestBody OffersDTO offersDTO){
        return new ResponseEntity<>(offersService.newOffers(offersDTO), HttpStatus.OK);
    }

    @GetMapping("offers/getOne/{id}")
    public ResponseEntity<OffersDTO> getOffersById (@PathVariable UUID id){
        OffersDTO offersDto = offersService.getOfferById(id);
        if (offersDto != null){
            return new ResponseEntity<>(offersDto, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(offersDto, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("offers/getAll")
    public  ResponseEntity<List<OffersDTO>> getAllOffers (){
        List<OffersDTO> offersDTOList = offersService.getAllOffers();
        return new ResponseEntity<>(offersDTOList, HttpStatus.OK);
    }

    @PutMapping("offers/updateModels/{id}")
    public ResponseEntity<OffersDTO> updateOffersById (UUID id, OffersDTO offersDTO){
        OffersDTO updateOffers = offersService.updateOffers(id, offersDTO);

        if (updateOffers != null){
            return new ResponseEntity<>(updateOffers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(updateOffers, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("offers/delete/{id}")
    public ResponseEntity<Void> deleteOffersById (@PathVariable UUID id){
        offersService.deleteOffers(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
