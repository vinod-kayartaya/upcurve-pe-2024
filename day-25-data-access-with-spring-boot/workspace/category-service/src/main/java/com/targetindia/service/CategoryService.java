package com.targetindia.service;

import com.targetindia.entity.Category;
import com.targetindia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category getCategory(Integer id) throws ServiceException {
        try{
            return repo.findById(id).orElse(null);
        }
        catch (Exception ex){
            throw new ServiceException(ex);
        }
    }

    public List<Category> getAllCategories() throws ServiceException{
        try{
            return repo.findAll();
        }
        catch (Exception ex){
            throw new ServiceException(ex);
        }
    }
}
