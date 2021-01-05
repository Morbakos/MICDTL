package com.example.CarRental;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalService {
	
	private List<Car> cars = new ArrayList<Car>();
	
	public CarRentalService() {
		cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
	}
	
	@GetMapping("/cars")
	public List<Car> getListOfCars(){
		return cars;
	}
	
	@PostMapping("/cars")
	public void addCar(@RequestBody Car car) throws Exception{
		System.out.println(car);
		cars.add(car);
	}

	@GetMapping("/cars/{plateNumber}")
	public Car getCar(@PathVariable(value = "plateNumber") String plateNumber){
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				return car;
			}
		}
		return null;
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent",
			required = true)boolean rent, @RequestBody Dates dates){
		System.out.println(dates);
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRent(rent, dates);
			}
		}
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
	public void deleteCar(@PathVariable("plateNumber") String plateNumber) {
		int carToDelete = -1;
		for (Car car: cars){
			if (car.getPlateNumber().equals(plateNumber)){
				carToDelete = cars.indexOf(car);
			}
		}
		if (carToDelete != -1) { cars.remove(carToDelete); }
	}

}
