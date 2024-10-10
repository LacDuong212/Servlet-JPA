package LD01.dao;

import LD01.entity.Category;

import java.util.List;

public interface ICategoryDao {

    void insert(Category category);

    void update(Category category);

    void delete(int cateid) throws Exception;

    Category findById(int cateid);

    int count();

    List<Category> findAll(int page, int pagesize);

    List<Category> findByCategoryname(String catname);

    List<Category> findAll();

    void deleteCategoryWithVideos(int categoryId);
}
