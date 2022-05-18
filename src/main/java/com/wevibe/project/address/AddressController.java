package com.wevibe.project.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping("")
    public List<Address> getAll() {
        return addressRepository.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable("id") Long id) {
        return addressRepository.getAddressById(id);
    }

    @PostMapping("")
    public int add(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Address updatedAddress) {
        Address address = addressRepository.getAddressById(id);

        if (address != null) {
            address.setNameAddress(updatedAddress.getNameAddress());
            address.setCountry(updatedAddress.getCountry());
            address.setCity(updatedAddress.getCity());
            address.setPostalCode(updatedAddress.getPostalCode());
            address.setStreet(updatedAddress.getStreet());
            address.setStreetNumber(updatedAddress.getStreetNumber());
            address.setApartmentNumber(updatedAddress.getApartmentNumber());

            addressRepository.update(address);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody Address updatedAddress) {
        Address address = addressRepository.getAddressById(id);

        if (address != null) {
            if (updatedAddress.getNameAddress() != null) address.setNameAddress(updatedAddress.getNameAddress());
            if (updatedAddress.getCountry() != null) address.setCountry(updatedAddress.getCountry());
            if (updatedAddress.getCity() != null) address.setCity(updatedAddress.getCity());
            if (updatedAddress.getPostalCode() != null) address.setPostalCode(updatedAddress.getPostalCode());
            if (updatedAddress.getStreet() != null) address.setStreet(updatedAddress.getStreet());
            if (updatedAddress.getStreetNumber() != null) address.setStreetNumber(updatedAddress.getStreetNumber());
            if (updatedAddress.getApartmentNumber() != null) address.setApartmentNumber(updatedAddress.getApartmentNumber());

            addressRepository.update(address);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return addressRepository.delete(id);
    }


}
