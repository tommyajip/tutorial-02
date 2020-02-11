package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.calculatorModel;

@Controller
public class CalculatorController {
    @RequestMapping(value="/calculatorConvert", method = RequestMethod.GET)
    public String getCalculatorModel(){
        return "calculatorConvert";
    }
    @RequestMapping(value="/calculatorConvert", method = RequestMethod.POST)
    public String proses(@RequestParam("angka1")int ang_satu, 
    		@RequestParam("angka2")int ang_dua, 
    		@ModelAttribute(name = "prosesPerhitungan") calculatorModel prosesPerhitungan, 
    		ModelMap model) {
    	prosesPerhitungan.setAngka_satu(ang_satu);
    	prosesPerhitungan.setAngka_dua(ang_dua);
    	model.addAttribute("satu", prosesPerhitungan.getAngka_satu());
    	model.addAttribute("dua", prosesPerhitungan.getAngka_satu());
    	
    	int hasil = prosesPerhitungan.proses(ang_satu, ang_dua);
    	model.addAttribute("hasil", hasil);
    	
    	String kataKata = prosesPerhitungan.kataKata(hasil);
    	model.addAttribute("kataKata", kataKata);
        return "calculatorConvert";        
    } 
}