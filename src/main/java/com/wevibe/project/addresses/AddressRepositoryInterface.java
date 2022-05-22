package com.wevibe.project.addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryInterface extends JpaRepository<Address, Long> {
}
