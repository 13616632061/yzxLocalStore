package com.yzx.yzxlocalstore.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yzx.yzxlocalstore.entity.GoodsType;

import com.yzx.yzxlocalstore.entity.GoodsInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GOODS_INFO".
*/
public class GoodsInfoDao extends AbstractDao<GoodsInfo, Long> {

    public static final String TABLENAME = "GOODS_INFO";

    /**
     * Properties of entity GoodsInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property GoodName = new Property(1, String.class, "goodName", false, "GOOD_NAME");
        public final static Property GoodPrice = new Property(2, double.class, "goodPrice", false, "GOOD_PRICE");
        public final static Property GoodOriginalPrice = new Property(3, double.class, "goodOriginalPrice", false, "GOOD_ORIGINAL_PRICE");
        public final static Property GoodStore = new Property(4, double.class, "goodStore", false, "GOOD_STORE");
        public final static Property GoodStoreWarningNum = new Property(5, double.class, "goodStoreWarningNum", false, "GOOD_STORE_WARNING_NUM");
        public final static Property GoodProfit = new Property(6, double.class, "goodProfit", false, "GOOD_PROFIT");
        public final static Property GoodStatus = new Property(7, boolean.class, "goodStatus", false, "GOOD_STATUS");
        public final static Property GoodCode = new Property(8, String.class, "goodCode", false, "GOOD_CODE");
        public final static Property GoodPinyinCode = new Property(9, String.class, "goodPinyinCode", false, "GOOD_PINYIN_CODE");
        public final static Property GoodType = new Property(10, int.class, "goodType", false, "GOOD_TYPE");
    }

    private DaoSession daoSession;


    public GoodsInfoDao(DaoConfig config) {
        super(config);
    }
    
    public GoodsInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GOODS_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"GOOD_NAME\" TEXT UNIQUE ," + // 1: goodName
                "\"GOOD_PRICE\" REAL NOT NULL ," + // 2: goodPrice
                "\"GOOD_ORIGINAL_PRICE\" REAL NOT NULL ," + // 3: goodOriginalPrice
                "\"GOOD_STORE\" REAL NOT NULL ," + // 4: goodStore
                "\"GOOD_STORE_WARNING_NUM\" REAL NOT NULL ," + // 5: goodStoreWarningNum
                "\"GOOD_PROFIT\" REAL NOT NULL ," + // 6: goodProfit
                "\"GOOD_STATUS\" INTEGER NOT NULL ," + // 7: goodStatus
                "\"GOOD_CODE\" TEXT," + // 8: goodCode
                "\"GOOD_PINYIN_CODE\" TEXT," + // 9: goodPinyinCode
                "\"GOOD_TYPE\" INTEGER NOT NULL );"); // 10: goodType
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GOODS_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GoodsInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String goodName = entity.getGoodName();
        if (goodName != null) {
            stmt.bindString(2, goodName);
        }
        stmt.bindDouble(3, entity.getGoodPrice());
        stmt.bindDouble(4, entity.getGoodOriginalPrice());
        stmt.bindDouble(5, entity.getGoodStore());
        stmt.bindDouble(6, entity.getGoodStoreWarningNum());
        stmt.bindDouble(7, entity.getGoodProfit());
        stmt.bindLong(8, entity.getGoodStatus() ? 1L: 0L);
 
        String goodCode = entity.getGoodCode();
        if (goodCode != null) {
            stmt.bindString(9, goodCode);
        }
 
        String goodPinyinCode = entity.getGoodPinyinCode();
        if (goodPinyinCode != null) {
            stmt.bindString(10, goodPinyinCode);
        }
        stmt.bindLong(11, entity.getGoodType());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GoodsInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String goodName = entity.getGoodName();
        if (goodName != null) {
            stmt.bindString(2, goodName);
        }
        stmt.bindDouble(3, entity.getGoodPrice());
        stmt.bindDouble(4, entity.getGoodOriginalPrice());
        stmt.bindDouble(5, entity.getGoodStore());
        stmt.bindDouble(6, entity.getGoodStoreWarningNum());
        stmt.bindDouble(7, entity.getGoodProfit());
        stmt.bindLong(8, entity.getGoodStatus() ? 1L: 0L);
 
        String goodCode = entity.getGoodCode();
        if (goodCode != null) {
            stmt.bindString(9, goodCode);
        }
 
        String goodPinyinCode = entity.getGoodPinyinCode();
        if (goodPinyinCode != null) {
            stmt.bindString(10, goodPinyinCode);
        }
        stmt.bindLong(11, entity.getGoodType());
    }

    @Override
    protected final void attachEntity(GoodsInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public GoodsInfo readEntity(Cursor cursor, int offset) {
        GoodsInfo entity = new GoodsInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // goodName
            cursor.getDouble(offset + 2), // goodPrice
            cursor.getDouble(offset + 3), // goodOriginalPrice
            cursor.getDouble(offset + 4), // goodStore
            cursor.getDouble(offset + 5), // goodStoreWarningNum
            cursor.getDouble(offset + 6), // goodProfit
            cursor.getShort(offset + 7) != 0, // goodStatus
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // goodCode
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // goodPinyinCode
            cursor.getInt(offset + 10) // goodType
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GoodsInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGoodName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setGoodPrice(cursor.getDouble(offset + 2));
        entity.setGoodOriginalPrice(cursor.getDouble(offset + 3));
        entity.setGoodStore(cursor.getDouble(offset + 4));
        entity.setGoodStoreWarningNum(cursor.getDouble(offset + 5));
        entity.setGoodProfit(cursor.getDouble(offset + 6));
        entity.setGoodStatus(cursor.getShort(offset + 7) != 0);
        entity.setGoodCode(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setGoodPinyinCode(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setGoodType(cursor.getInt(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(GoodsInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(GoodsInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(GoodsInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getGoodsTypeDao().getAllColumns());
            builder.append(" FROM GOODS_INFO T");
            builder.append(" LEFT JOIN GOODS_TYPE T0 ON T.\"_id\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected GoodsInfo loadCurrentDeep(Cursor cursor, boolean lock) {
        GoodsInfo entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        GoodsType goodsType = loadCurrentOther(daoSession.getGoodsTypeDao(), cursor, offset);
        entity.setGoodsType(goodsType);

        return entity;    
    }

    public GoodsInfo loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<GoodsInfo> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<GoodsInfo> list = new ArrayList<GoodsInfo>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<GoodsInfo> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<GoodsInfo> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}