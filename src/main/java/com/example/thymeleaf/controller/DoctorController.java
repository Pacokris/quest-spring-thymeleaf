package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
public class DoctorController {

    private static final String TEMPLATE_INDEX = "/index";
    private static final String TEMPLATE_DOCTOR = "/doctor";

    /**
     * Affiche la page index
     *
     * @param model affiches les options sur la page index
     * @return les informations à afficher sur l'écran /index.html
     */
    @GetMapping({"/", TEMPLATE_INDEX})
    public ModelAndView displayIndex(Map<String, Object> model){
        return new ModelAndView( TEMPLATE_INDEX, model );
    }

    @GetMapping("/doctor")
    public ModelAndView doctor(Doctor doctor, Map<String, Object> model) {

        int number = doctor.getNumber();
        String name = doctor.getName();

        if (name == null) {
            name = "John Smith";
        }

        model.put("number", number);
        model.put("name", name);

        return new ModelAndView( TEMPLATE_DOCTOR, model );
    }
}
