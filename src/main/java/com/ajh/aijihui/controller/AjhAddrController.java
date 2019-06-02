package com.ajh.aijihui.controller;

import com.ajh.aijihui.service.AjhAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ajhAddr")
@CrossOrigin(origins = {"*","null"})
public class AjhAddrController {

	@Autowired
	private AjhAddrService ajhAddrService;



}