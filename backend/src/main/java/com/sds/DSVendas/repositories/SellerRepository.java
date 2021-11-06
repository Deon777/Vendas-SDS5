package com.sds.DSVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sds.DSVendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
