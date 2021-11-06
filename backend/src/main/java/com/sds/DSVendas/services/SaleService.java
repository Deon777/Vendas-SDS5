package com.sds.DSVendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.DSVendas.dto.SaleDTO;
import com.sds.DSVendas.dto.SellersSaleSumDTO;
import com.sds.DSVendas.dto.SellersSuccessDTO;
import com.sds.DSVendas.entities.Sale;
import com.sds.DSVendas.repositories.SaleRepository;
import com.sds.DSVendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SellersSaleSumDTO> amountGroupedBySeller(){
		sellerRepository.findAll();
		return repository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SellersSuccessDTO> successGroupedBySeller(){
		sellerRepository.findAll();
		return repository.successGroupedBySeller();
	}
}
