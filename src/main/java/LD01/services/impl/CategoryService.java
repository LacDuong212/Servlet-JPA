package LD01.services.impl;

import LD01.dao.ICategoryDao;
import LD01.dao.impl.CategoryDao;
import LD01.entity.Category;
import LD01.services.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    ICategoryDao cateDao = new CategoryDao();

    @Override
    public int count() {

        return cateDao.count();
    }

    @Override
    public List<Category> findAll(int page, int pagesize) {

        return cateDao.findAll(page, pagesize);
    }

    @Override
    public List<Category> findByCategoryname(String catname) {

        return cateDao.findByCategoryname(catname);
    }

    @Override
    public List<Category> findAll() {

        return cateDao.findAll();
    }

    @Override
    public Category findById(int cateid) {

        return cateDao.findById(cateid);
    }

    @Override
    public void delete(int cateid) throws Exception {
        cateDao.delete(cateid);
    }

    @Override
    public void update(Category category) {
        cateDao.update(category);
    }

    @Override
    public void insert(Category category) {
        cateDao.insert(category);
    }

    @Override
    public void deleteCategoryWithVideos(int categoryId) {
        cateDao.deleteCategoryWithVideos(categoryId);
    }


}
