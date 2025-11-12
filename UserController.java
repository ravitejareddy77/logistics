package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoPackage.OrderDto;
import com.example.demo.dtoPackage.ResponseStructure;
import com.example.demo.entitypackage.Order;
import com.example.demo.servicepackage.CargoService;
import com.example.demo.servicepackage.OrderService;

@RestController
public class UserController {
	@Autowired
	private OrderService orderservice;

	@Autowired
	private CargoService cargoservice;

	@PostMapping("/saveorder")
	public ResponseEntity<ResponseStructure<Order>> save(@RequestBody OrderDto order) {
		System.err.println(order);
		 return orderservice.saveOrder(order);
	}
	
	@PutMapping("/updateorder/{id}/truckid/{truckid}")
	public ResponseEntity<ResponseStructure<Order>> updateOrder(@PathVariable int id,@PathVariable int truckid) {
		 return orderservice.updateOrders(id,truckid);
	}
	@PutMapping("/updateload/{id}")
	public ResponseEntity<ResponseStructure<Order>> update(@PathVariable int id) {
		 return orderservice.updateLoading(id);
	}
	@PutMapping("/updateunload/{id}")
	public ResponseEntity<ResponseStructure<Order>> updatec(@PathVariable int id) {
		 return orderservice.updateUnLoading(id);
	}
}
