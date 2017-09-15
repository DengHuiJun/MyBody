package com.zero.mybody.db;

/**
 * Created by zero on 16-9-21.
 */
public class DataManager implements CategoryDao {

    /*
    private BriteDatabase mBriteDatabase;

    private static DataManager INSTANCE;

    public static DataManager getInstance(Context context) {
        if (context == null) {
            throw new NullPointerException("context must not be null!");
        }

        if (INSTANCE == null) {
            INSTANCE = new DataManager(context);
        }

        return INSTANCE;
    }

    private DataManager(Context context) {
        mBriteDatabase = SqlBrite.create().wrapDatabaseHelper(new DatabaseHelper(context), Schedulers.io());
    }

    private void addCategory(@NonNull Category category) {
        ContentValues cv = new ContentValues();
        cv.put("id", category.getId());
        cv.put("name", category.getName());
        cv.put("seq", category.getSeq());
        cv.put("title", category.getTitle());
        cv.put("description", category.getDescription());
        cv.put("keywords", category.getKeywords());
        cv.put("createdTime", System.currentTimeMillis());
        cv.put("lastUpdateTime", System.currentTimeMillis());
        mBriteDatabase.insert("t_category", cv);
    }

    private void addCategoryItem(CategoryItem categoryItem) {
        ContentValues cv = new ContentValues();
        cv.put("createdTime", System.currentTimeMillis());
        cv.put("lastUpdateTime", System.currentTimeMillis());
        cv.put("id", categoryItem.getId());
        cv.put("title", categoryItem.getTitle());
        cv.put("time", categoryItem.getTime());
        cv.put("keywords", categoryItem.getKeywords());
        cv.put("description", categoryItem.getDescription());
        cv.put("img", categoryItem.getImg());
        cv.put("infoclass", categoryItem.getInfoclass());
        cv.put("fcount", categoryItem.getFcount());
        cv.put("rcount", categoryItem.getRcount());
        cv.put("count", categoryItem.getCount());
        mBriteDatabase.insert("t_category_item", cv);
    }


    @Override
    public void addCategoryList(Category... category) {
        if (category.length <= 0) {
            return;
        }

        BriteDatabase.Transaction transaction = mBriteDatabase.newTransaction();
        try {
            for (Category item : category) {
                addCategory(item);
            }
            transaction.markSuccessful();
        } finally {
            transaction.end();
        }
    }

    @Override
    public Observable<List<Category>> getCategoryList() {
        String[] projection = {CategoryColumn.ID, CategoryColumn.TITLE};
        String sql = String.format("SELECT %s FROM %s", TextUtils.join(",", projection), CategoryColumn.TABLE_NAME);
        return mBriteDatabase.createQuery(CategoryColumn.TABLE_NAME, sql, new String[]{})
                .mapToList(new Func1<Cursor, Category>() {
            @Override
            public Category call(Cursor cursor) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(CategoryColumn.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(CategoryColumn.TITLE));
                return new Category(id, title);
            }
        });
    }

    @Override
    public void deleteAllCategory() {
        mBriteDatabase.delete(CategoryColumn.TABLE_NAME, null, new String[]{});
    }

    @Override
    public void addCategoryItemList(CategoryItem... categoryItems) {
        if (categoryItems.length <= 0) {
            return;
        }

        BriteDatabase.Transaction transaction = mBriteDatabase.newTransaction();
        try {
            for (CategoryItem item : categoryItems) {
                addCategoryItem(item);
            }
            transaction.markSuccessful();
        } finally {
            transaction.end();
        }
    }

    @Override
    public Observable<List<CategoryItem>> getCategoryItemList() {

        String sql = "SELECT * FROM t_category_item";
        return mBriteDatabase.createQuery(CategoryItemColumn.TABLE_NAME, sql, new String[]{})
                .mapToList(new Func1<Cursor, CategoryItem>() {
                    @Override
                    public CategoryItem call(Cursor cursor) {
                        int id = cursor.getInt(cursor.getColumnIndexOrThrow(CategoryItemColumn.ID));


                        return null;
                    }
                });
    }

    @Override
    public void deleteAllCategoryItem() {
        mBriteDatabase.delete(CategoryItemColumn.TABLE_NAME, null, new String[]{});
    }
    */
}
