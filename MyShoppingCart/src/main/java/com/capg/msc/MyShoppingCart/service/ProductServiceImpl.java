package com.capg.msc.MyShoppingCart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.msc.MyShoppingCart.beans.Product;
import com.capg.msc.MyShoppingCart.dao.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository repo;
	
	
	@Override
	public List<Product> getAllProducts(){
		
		return repo.findAll();
	}
	
	@Override
	@Transactional
	public Product saveProduct(Product p) {
		repo.save(p);
		return p;
	}
	
	public boolean deleteProduct(Product p, int pId) {
		boolean isDeleted = false;
		Product p1 = null;
		List<Product> pList = getAllProducts();
		for(Product product : pList) {
			if(product.getId() == pId) {
				isDeleted = true;
				p1 = product;
			}
		}
		repo.delete(p);
		return isDeleted;
		
	}
}
