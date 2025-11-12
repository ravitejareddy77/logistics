package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dtoPackage.ResponseStructure;
import com.example.demo.dtoPackage.TruckDto;
import com.example.demo.entitypackage.Address;
import com.example.demo.entitypackage.Carrier;
import com.example.demo.entitypackage.Driver;
import com.example.demo.entitypackage.Truck;
import com.example.demo.repositorypackage.LoadingRepository;
import com.example.demo.repositorypackage.UnloadingRepository;
import com.example.demo.servicepackage.AddressService;
import com.example.demo.servicepackage.CarrierService;
import com.example.demo.servicepackage.DriverService;
import com.example.demo.servicepackage.TruckService;

import jakarta.validation.Valid;

@RestController
public class AdminController {

	@Autowired
	private DriverService driser;

	@Autowired
	private TruckService truser;

	@Autowired
	private CarrierService carser;

	@Autowired
	private AddressService aser;

	@PostMapping("/saveDriver")
	public ResponseEntity<ResponseStructure<Driver>> SaveDriver(@RequestBody Driver dri) {
		return driser.saveDriver(dri);
	}

	@GetMapping("/saveDriver")
	public ResponseEntity<ResponseStructure<Driver>> findDriver(@RequestParam int id) {
		return driser.findDriver(id);
	}

	@DeleteMapping("/saveDriver")
	public ResponseEntity<ResponseStructure<Driver>> delDriver(@RequestParam int id) {
		return driser.deleteDriver(id);
	}

	@PostMapping("saveTruck")
	public ResponseEntity<ResponseStructure<Truck>> savetruck(@RequestBody Truck truck) {
		return truser.saveTruck(truck);
	}

	@GetMapping("/saveTruck")
	public ResponseEntity<ResponseStructure<Truck>> findTruck(@RequestParam int id) {
		return truser.findtruck(id);

	}

	@DeleteMapping("/saveTruck")
	public ResponseEntity<ResponseStructure<Truck>> deltru(@RequestParam int id) {
		return truser.delTruck(id);
	}

	@PostMapping("/saveCarrier")
	public ResponseEntity<ResponseStructure<Carrier>> savecarrier(@Valid @RequestBody Carrier car) {
		return carser.saveCarrier(car);
	}

	@GetMapping("/saveCarrier")
	public ResponseEntity<ResponseStructure<Carrier>> findcarrier(@RequestParam int id) {
		return carser.FindCarrier(id);
	}

	@DeleteMapping("/saveCarrier")
	public ResponseEntity<ResponseStructure<Carrier>> deleteCar(@RequestParam int id) {
		return carser.DeleteCarrier(id);
	}
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address add) {
	return 	aser.SaveAddress(add);
	}
	@GetMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> findaddr(@RequestParam int id) {
		 return aser.FindAddress(id);
	}
	@DeleteMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> del(@RequestParam int id) {
		 return aser.DeleteAddress(id);
	}
	
	@PutMapping("/savetruck1")
	public ResponseEntity<ResponseStructure<Truck>> updatetruck(@RequestBody TruckDto trdto) {
		 return truser.updateTruck(trdto);
	}
	
	@PutMapping("/updateDriver/{id}/{truckid}/{carrierid}")
	public ResponseEntity<ResponseStructure<Driver>> update(@PathVariable int id, @PathVariable int truckid, @PathVariable int carrierid) {
		  return driser.updateDriver(id, truckid, carrierid);
		
	}


}
