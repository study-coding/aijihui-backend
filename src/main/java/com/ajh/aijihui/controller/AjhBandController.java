package com.ajh.aijihui.controller;

import com.ajh.aijihui.service.AjhBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ajhBand")
@CrossOrigin(origins = {"*","null"})
public class AjhBandController {

    @Autowired
    private AjhBandService ajhBandService;

}