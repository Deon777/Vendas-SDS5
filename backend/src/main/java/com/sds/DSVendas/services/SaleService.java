package com.sds.DSVendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.DSVendas.dto.SaleDTO;
import com.sds.DSVendas.entities.Sale;
import com.sds.DSVendas.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<SaleDTO> findAll(){
		List<Sale> result = repository.findAll();
		return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
	}
	
}
