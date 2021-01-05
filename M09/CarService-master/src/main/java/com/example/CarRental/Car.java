package com.example.CarRental;

public class Car {
	
	private String plateNumber;
	private String brand;
	private int price;
	private boolean rent;
	private Dates dateLocation;
	
	public Car() {
		super();
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}

	public Dates getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(Dates dateLocation) {
		this.dateLocation = dateLocation;
	}

	public Car(String plateNumber, String brand, int price) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
		this.rent = false;
		this.dateLocation = new Dates();
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isRent() { return rent; }

	public void setRent(boolean rent, Dates dates) {
		this.rent = rent;
		this.dateLocation = dates;
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
	}

}
