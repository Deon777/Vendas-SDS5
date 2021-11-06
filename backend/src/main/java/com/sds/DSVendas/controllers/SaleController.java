package com.sds.DSVendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.DSVendas.dto.SaleDTO;
import com.sds.DSVendas.dto.SellersSaleSumDTO;
import com.sds.DSVendas.dto.SellersSuccessDTO;
import com.sds.DSVendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);	
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SellersSaleSumDTO>> amountGroupedBySeller(){
		List<SellersSaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);	
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SellersSuccessDTO>> successGroupedBySeller(){
		List<SellersSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);	
	}
}
