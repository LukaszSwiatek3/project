package com.wevibe.project.addresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Address> getAll() {
        return jdbcTemplate.query("SELECT id_address, name_address, city, country, postal_code, street, street_number, apartment_number "
                + "FROM addresses", BeanPropertyRowMapper.newInstance(Address.class));
    }

    public Address getAddressById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_address, name_address, city, country, postal_code, street, street_number, apartment_number "
                + "FROM addresses WHERE " + "id_address = ?", BeanPropertyRowMapper.newInstance(Address.class), id);
    }

    public int save(Address addresses) {
        jdbcTemplate.update("INSERT INTO addresses(name_address, city, country, postal_code, street, street_number, apartment_number) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)", addresses.getNameAddress(), addresses.getCity(), addresses.getCountry(), addresses.getPostalCode(), addresses.getStreet(), addresses.getStreetNumber(), addresses.getApartmentNumber());
        return 1;
    }

    public int update(Address address) {
        return jdbcTemplate.update("UPDATE addresses SET name_address=?, country=?, city=?, postal_code=?, street=?, street_number=?, apartment_number=? "
                + "WHERE id_address=?", address.getNameAddress(), address.getCountry(), address.getCity(), address.getPostalCode(), address.getStreet(), address.getStreetNumber(), address.getApartmentNumber());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM addresses WHERE id_address=?", id);
    }

}
