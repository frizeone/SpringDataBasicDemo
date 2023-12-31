package com.example.springdatabasicdemo.controllers;


import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.services.BrandsService;
import com.example.springdatabasicdemo.services.ModelsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Models")
public class ModelsController {

    private final ModelsService modelsService;

    private final BrandsService brandsService;

    @Autowired
    public ModelsController(ModelsService modelsService, BrandsService brandsService){
        this.modelsService = modelsService;
        this.brandsService = brandsService;
    }


    @GetMapping("/vive")
    public String viveModels(){
        return "Models-all";
    }

    @GetMapping("/add")
    public  String addModels(Model model) {

        model.addAttribute("allBrand", brandsService.getAllBrands());
        return "Models-add";
    }



    @GetMapping("/vive/Models-details/{name}/{startYear}/{endYear}")
    public String getDetailsModels(@PathVariable("name") String name, @PathVariable("startYear") int startYear, @PathVariable("endYear") int endYear, Model model){
        model.addAttribute("modelAtribute", modelsService.getModelByThreeParam(name,startYear,endYear));
        return "Models-details";
    }

    @GetMapping("/vive/Models-delete/{name}/{startYear}/{endYear}")
    public String deleteModels (@PathVariable("name") String name, @PathVariable("startYear") int startYear, @PathVariable("endYear") int endYear, Model model){
        modelsService.deleteThreeParam(name, startYear, endYear);
        return "redirect:/Models/all";
    }


    @PostMapping("models/add")
    public ResponseEntity<ModelsDTO> addNewModels (@RequestBody ModelsDTO modelsDTO, @RequestParam("imageFile") MultipartFile imageFile){
        return new ResponseEntity<>(modelsService.addNewModels(modelsDTO, imageFile), HttpStatus.OK);
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
        model.addAttribute("topThreeModel", modelsService.getTopThreeModels());
        return "Models-all";
    }

    @ModelAttribute("modelsModel")
    public ModelsDTO initModels(){
        return new ModelsDTO();
    }

    @PostMapping("/add")
    public String addModel(@Valid ModelsDTO modelsDTO, @RequestParam("imageFile")MultipartFile imageFile, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("modelsDTO", modelsDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelDTO", bindingResult);
            return "redirect:/Models/add";
        }
        modelsService.addNewModels(modelsDTO, imageFile);
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

    @DeleteMapping("/models-delete/{name}")
    public String deleteBrands (@PathVariable("") String name){
        modelsService.deleteModelsByname(name);
        return "redirect: /Models/vive";
    }





}
