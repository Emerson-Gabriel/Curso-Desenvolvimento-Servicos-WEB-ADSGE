package com.emerson.curso.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emerson.curso.dto.CategoryDTO;
import com.emerson.curso.entities.Category;
import com.emerson.curso.entities.Product;
import com.emerson.curso.repositories.CategoryRepository;
import com.emerson.curso.repositories.ProductRepository;
import com.emerson.curso.services.exceptions.DatabaseException;
import com.emerson.curso.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<CategoryDTO> findAll(){
		List<Category> list= repository.findAll();
		return list.stream().map(e -> new CategoryDTO(e)).collect(Collectors.toList());
	}
	
	public CategoryDTO findById(Long id) {
		
		Optional<Category> obj= repository.findById(id);
		Category entity= obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CategoryDTO(entity);
	}
	
	public CategoryDTO insert(CategoryDTO obj) {
				
		Category entity= obj.toEntity();
		entity= repository.save(entity);	
		return new CategoryDTO(entity);	
	}
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
			throw new ResourceNotFoundException(id);
		
		}catch(DataIntegrityViolationException ex){
			throw new DatabaseException(ex.getMessage());
		}
	}
	
	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
		Category entity= repository.getOne(id);
		updateData(entity, dto);
		entity= repository.save(entity);
		return new CategoryDTO(entity);
		
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	
	}
	private void updateData(Category entity, CategoryDTO dto) {
		// TODO Auto-generated method stub
		entity.setName(dto.getName());
		
	}
	
	@Transactional(readOnly=true)
	public List<CategoryDTO> findByProduct(Long productId) {
		Product product = productRepository.getOne(productId);
		Set<Category> set= product.getCategories();

		return set.stream().map(e -> new CategoryDTO(e)).collect(Collectors.toList());

	}

}
