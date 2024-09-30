package com.ra.model.dao.category;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    Boolean create(Category category);
    Boolean update(Category category);
    Category findById(Integer id);
    void delete(Integer id);
}
