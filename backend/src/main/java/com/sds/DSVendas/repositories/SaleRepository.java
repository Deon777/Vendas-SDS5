package com.sds.DSVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sds.DSVendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
