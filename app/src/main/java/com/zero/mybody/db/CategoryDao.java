package com.zero.mybody.db;

import com.zero.mybody.jsonResult.CategoryItemResult.CategoryItem;
import com.zero.mybody.jsonResult.CategoryResult.Category;

import java.util.List;

import rx.Observable;

/**
 * Created by zero on 16-9-21.
 */
public interface CategoryDao {

    void addCategoryList(Category... category);

    Observable<List<Category>> getCategoryList();

    void deleteAllCategory();

    void addCategoryItemList(CategoryItem... categoryItems);

    Observable<List<CategoryItem>> getCategoryItemList();

    void deleteAllCategoryItem();
}
