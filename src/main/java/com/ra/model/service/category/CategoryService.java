package com.ra.model.service.category;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Boolean create(Category category);
    Boolean update(Category category);
    Category findById(Integer id);
    void delete(Integer id);
}
