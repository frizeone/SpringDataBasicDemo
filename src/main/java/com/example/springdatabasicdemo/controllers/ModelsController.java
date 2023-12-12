package com.example.springdatabasicdemo.controllers;


import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.services.ModelsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Models")
public class ModelsController {

    private final ModelsService modelsService;


    @Autowired
    public ModelsController(ModelsService modelsService){
        this.modelsService = modelsService;
    }


    @GetMapping("/vive")
    public String viveModels(){
        return "Models-all";
    }

    @GetMapping("/add")
    public  String addModels() {
        return "Models-add";
    }

    @PostMapping("models/add")
    public ResponseEntity<ModelsDTO> addNewModels (@RequestBody ModelsDTO modelsDTO){
        return new ResponseEntity<>(modelsService.addNewModels(modelsDTO), HttpStatus.OK);

    }




    @GetMapping("models/getOne/{id}")
    public ResponseEntity<ModelsDTO> takeOneById (@PathVariable UUID id){
        ModelsDTO modelsDTO = modelsService.geModelById(id);
        if(modelsDTO != null){
            return new ResponseEntity<>(modelsDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ModelsDTO>> getAllBrands(){
        List<ModelsDTO> modelsList = modelsService.getAllModels();
        return new ResponseEntity<>(modelsList, HttpStatus.OK);
    }

    @GetMapping("/all")
    public String getAllModels(Model model){
        model.addAttribute("allModels", modelsService.getAllModels());
        return "Models-all";
    }

    @ModelAttribute("modelsModel")
    public ModelsDTO initModels(){
        return new ModelsDTO();
    }

    @PostMapping("/add")
    public String addModel(@Valid ModelsDTO modelsDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("modelsDTO", modelsDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelDTO", bindingResult);
            return "redirect:/Models/add";
        }
        modelsService.addNewModels(modelsDTO);
        return "redirect:/Models/all";
    }



    @PutMapping("models/updateModelsByName/{name}")
    public ResponseEntity<ModelsDTO> updateModelsByname (@PathVariable String name, @RequestBody ModelsDTO modelsDTO){
        ModelsDTO updateModels = modelsService.updateModelsByName(name, modelsDTO);

        if(updateModels != null){
            return new ResponseEntity<>(updateModels, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updateModels, HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("models/updateModels/{id}")
    public ResponseEntity<ModelsDTO> updateModels (@PathVariable UUID id, @RequestBody ModelsDTO modelsDTO){
        ModelsDTO updateModels = modelsService.updateModels(id, modelsDTO);

        if (updateModels != null){
            return new ResponseEntity<>(updateModels, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updateModels, HttpStatus.NOT_FOUND);
        }
    }

//
//    @DeleteMapping("brand/delete/{id}")
//    public ResponseEntity<Void> deleteBrands (@PathVariable int id){
//        brandsSevices.deleteBrands(id);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @DeleteMapping("models/delete/{name}")
    public ResponseEntity<Void> deleteBrands (@PathVariable String name){
        modelsService.deleteModelsByname(name);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





}
