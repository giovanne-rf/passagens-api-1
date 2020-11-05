package com.gama.passagens.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.amadeus.order.FlightOrderService;
import com.gama.passagens.project.service.VooService;

@RestController
@RequestMapping("/voos")
public class VooController {
	@Autowired
	private VooService service;
	
	@Autowired
	private FlightOrderService orderService;
	
	@PostMapping("")
	public Object voos(@RequestBody Map<String,String> params) {
		try {
			return service.consultaVoos(params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	
	}
	@PostMapping("/order")
	public void order(@RequestBody Map order) {
		try {
			orderService.order(order);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    	
	}
}
