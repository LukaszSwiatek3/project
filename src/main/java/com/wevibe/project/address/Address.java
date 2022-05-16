//package com.wevibe.project.address;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Addresses")
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long idAddress;
//    @Column(name = "name_address", nullable = true, length = 45)
//    private String nameAddress;
//    @Column(name = "country", nullable = false, length = 45)
//    private String country;
//    @Column(name = "city", nullable = false, length = 45)
//    private String city;
//    @Column(name = "postal_code", nullable = false, length = 6)
//    private String postalCode;
//    @Column(name = "street", nullable = false, length = 45)
//
//    private String street;
//    @Column(name = "street_number", nullable = false)
//    private Integer streetNumber;
//    @Column(name = "apartment_number", nullable = true)
//    private Integer apartmentNumber;
//
//    public Address() {
//    }
//
//    public Address(Long idAddress, String nameAddress, String country, String city, String postalCode, String street, Integer streetNumber, Integer apartmentNumber) {
//        this.idAddress = idAddress;
//        this.nameAddress = nameAddress;
//        this.country = country;
//        this.city = city;
//        this.postalCode = postalCode;
//        this.street = street;
//        this.streetNumber = streetNumber;
//        this.apartmentNumber = apartmentNumber;
//    }
//
//    public Long getIdAddress() {
//        return idAddress;
//    }
//
//    public String getNameAddress() {
//        return nameAddress;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public Integer getStreetNumber() {
//        return streetNumber;
//    }
//
//    public Integer getApartmentNumber() {
//        return apartmentNumber;
//    }
//
//    public void setIdAddress(Long idAddress) {
//        this.idAddress = idAddress;
//    }
//
//    public void setNameAddress(String nameAddress) {
//        this.nameAddress = nameAddress;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public void setStreetNumber(Integer streetNumber) {
//        this.streetNumber = streetNumber;
//    }
//
//    public void setApartmentNumber(Integer apartmentNumber) {
//        this.apartmentNumber = apartmentNumber;
//    }
//
//    @Override
//    public String toString() {
//        return street + " " + streetNumber + "/" + apartmentNumber + " " + city + " " + country;
//    }
//}