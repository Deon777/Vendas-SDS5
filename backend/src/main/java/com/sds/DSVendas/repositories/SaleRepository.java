package com.sds.DSVendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sds.DSVendas.dto.SellersSaleSumDTO;
import com.sds.DSVendas.dto.SellersSuccessDTO;
import com.sds.DSVendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.sds.DSVendas.dto.SellersSaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SellersSaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.sds.DSVendas.dto.SellersSuccessDTO(obj.seller,SUM(obj.visited),SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SellersSuccessDTO> successGroupedBySeller();
}
