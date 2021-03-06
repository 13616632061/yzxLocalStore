package com.yzx.yzxlocalstore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

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
        public final static Property GoodPrice = new Property(2, Double.class, "goodPrice", false, "GOOD_PRICE");
        public final static Property GoodOriginalPrice = new Property(3, Double.class, "goodOriginalPrice", false, "GOOD_ORIGINAL_PRICE");
        public final static Property GoodStore = new Property(4, Double.class, "goodStore", false, "GOOD_STORE");
        public final static Property GoodStoreWarningNum = new Property(5, Double.class, "goodStoreWarningNum", false, "GOOD_STORE_WARNING_NUM");
        public final static Property GoodProfit = new Property(6, Double.class, "goodProfit", false, "GOOD_PROFIT");
        public final static Property GoodStatus = new Property(7, Boolean.class, "goodStatus", false, "GOOD_STATUS");
        public final static Property GoodCode = new Property(8, String.class, "goodCode", false, "GOOD_CODE");
        public final static Property GoodPinyinCode = new Property(9, String.class, "goodPinyinCode", false, "GOOD_PINYIN_CODE");
        public final static Property GoodLoaction = new Property(10, Integer.class, "goodLoaction", false, "GOOD_LOACTION");
        public final static Property VipLevelOnePrice = new Property(11, Double.class, "vipLevelOnePrice", false, "VIP_LEVEL_ONE_PRICE");
        public final static Property VipLevelTwoPrice = new Property(12, Double.class, "vipLevelTwoPrice", false, "VIP_LEVEL_TWO_PRICE");
        public final static Property VipLevelThreePrice = new Property(13, Double.class, "vipLevelThreePrice", false, "VIP_LEVEL_THREE_PRICE");
        public final static Property VipLevelFourthPrice = new Property(14, Double.class, "vipLevelFourthPrice", false, "VIP_LEVEL_FOURTH_PRICE");
        public final static Property VipLevelFivePrice = new Property(15, Double.class, "vipLevelFivePrice", false, "VIP_LEVEL_FIVE_PRICE");
        public final static Property GoodBriefIntroduction = new Property(16, String.class, "goodBriefIntroduction", false, "GOOD_BRIEF_INTRODUCTION");
        public final static Property GoodRemarks = new Property(17, String.class, "goodRemarks", false, "GOOD_REMARKS");
        public final static Property IsSelect = new Property(18, Boolean.class, "isSelect", false, "IS_SELECT");
        public final static Property IsAllSelect = new Property(19, Boolean.class, "isAllSelect", false, "IS_ALL_SELECT");
        public final static Property Num = new Property(20, Double.class, "num", false, "NUM");
        public final static Property TypeName = new Property(21, String.class, "typeName", false, "TYPE_NAME");
        public final static Property Sort = new Property(22, Integer.class, "sort", false, "SORT");
    }


    public GoodsInfoDao(DaoConfig config) {
        super(config);
    }
    
    public GoodsInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GOODS_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"GOOD_NAME\" TEXT," + // 1: goodName
                "\"GOOD_PRICE\" REAL," + // 2: goodPrice
                "\"GOOD_ORIGINAL_PRICE\" REAL," + // 3: goodOriginalPrice
                "\"GOOD_STORE\" REAL," + // 4: goodStore
                "\"GOOD_STORE_WARNING_NUM\" REAL," + // 5: goodStoreWarningNum
                "\"GOOD_PROFIT\" REAL," + // 6: goodProfit
                "\"GOOD_STATUS\" INTEGER," + // 7: goodStatus
                "\"GOOD_CODE\" TEXT," + // 8: goodCode
                "\"GOOD_PINYIN_CODE\" TEXT," + // 9: goodPinyinCode
                "\"GOOD_LOACTION\" INTEGER," + // 10: goodLoaction
                "\"VIP_LEVEL_ONE_PRICE\" REAL," + // 11: vipLevelOnePrice
                "\"VIP_LEVEL_TWO_PRICE\" REAL," + // 12: vipLevelTwoPrice
                "\"VIP_LEVEL_THREE_PRICE\" REAL," + // 13: vipLevelThreePrice
                "\"VIP_LEVEL_FOURTH_PRICE\" REAL," + // 14: vipLevelFourthPrice
                "\"VIP_LEVEL_FIVE_PRICE\" REAL," + // 15: vipLevelFivePrice
                "\"GOOD_BRIEF_INTRODUCTION\" TEXT," + // 16: goodBriefIntroduction
                "\"GOOD_REMARKS\" TEXT," + // 17: goodRemarks
                "\"IS_SELECT\" INTEGER," + // 18: isSelect
                "\"IS_ALL_SELECT\" INTEGER," + // 19: isAllSelect
                "\"NUM\" REAL," + // 20: num
                "\"TYPE_NAME\" TEXT," + // 21: typeName
                "\"SORT\" INTEGER);"); // 22: sort
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
 
        Double goodPrice = entity.getGoodPrice();
        if (goodPrice != null) {
            stmt.bindDouble(3, goodPrice);
        }
 
        Double goodOriginalPrice = entity.getGoodOriginalPrice();
        if (goodOriginalPrice != null) {
            stmt.bindDouble(4, goodOriginalPrice);
        }
 
        Double goodStore = entity.getGoodStore();
        if (goodStore != null) {
            stmt.bindDouble(5, goodStore);
        }
 
        Double goodStoreWarningNum = entity.getGoodStoreWarningNum();
        if (goodStoreWarningNum != null) {
            stmt.bindDouble(6, goodStoreWarningNum);
        }
 
        Double goodProfit = entity.getGoodProfit();
        if (goodProfit != null) {
            stmt.bindDouble(7, goodProfit);
        }
 
        Boolean goodStatus = entity.getGoodStatus();
        if (goodStatus != null) {
            stmt.bindLong(8, goodStatus ? 1L: 0L);
        }
 
        String goodCode = entity.getGoodCode();
        if (goodCode != null) {
            stmt.bindString(9, goodCode);
        }
 
        String goodPinyinCode = entity.getGoodPinyinCode();
        if (goodPinyinCode != null) {
            stmt.bindString(10, goodPinyinCode);
        }
 
        Integer goodLoaction = entity.getGoodLoaction();
        if (goodLoaction != null) {
            stmt.bindLong(11, goodLoaction);
        }
 
        Double vipLevelOnePrice = entity.getVipLevelOnePrice();
        if (vipLevelOnePrice != null) {
            stmt.bindDouble(12, vipLevelOnePrice);
        }
 
        Double vipLevelTwoPrice = entity.getVipLevelTwoPrice();
        if (vipLevelTwoPrice != null) {
            stmt.bindDouble(13, vipLevelTwoPrice);
        }
 
        Double vipLevelThreePrice = entity.getVipLevelThreePrice();
        if (vipLevelThreePrice != null) {
            stmt.bindDouble(14, vipLevelThreePrice);
        }
 
        Double vipLevelFourthPrice = entity.getVipLevelFourthPrice();
        if (vipLevelFourthPrice != null) {
            stmt.bindDouble(15, vipLevelFourthPrice);
        }
 
        Double vipLevelFivePrice = entity.getVipLevelFivePrice();
        if (vipLevelFivePrice != null) {
            stmt.bindDouble(16, vipLevelFivePrice);
        }
 
        String goodBriefIntroduction = entity.getGoodBriefIntroduction();
        if (goodBriefIntroduction != null) {
            stmt.bindString(17, goodBriefIntroduction);
        }
 
        String goodRemarks = entity.getGoodRemarks();
        if (goodRemarks != null) {
            stmt.bindString(18, goodRemarks);
        }
 
        Boolean isSelect = entity.getIsSelect();
        if (isSelect != null) {
            stmt.bindLong(19, isSelect ? 1L: 0L);
        }
 
        Boolean isAllSelect = entity.getIsAllSelect();
        if (isAllSelect != null) {
            stmt.bindLong(20, isAllSelect ? 1L: 0L);
        }
 
        Double num = entity.getNum();
        if (num != null) {
            stmt.bindDouble(21, num);
        }
 
        String typeName = entity.getTypeName();
        if (typeName != null) {
            stmt.bindString(22, typeName);
        }
 
        Integer sort = entity.getSort();
        if (sort != null) {
            stmt.bindLong(23, sort);
        }
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
 
        Double goodPrice = entity.getGoodPrice();
        if (goodPrice != null) {
            stmt.bindDouble(3, goodPrice);
        }
 
        Double goodOriginalPrice = entity.getGoodOriginalPrice();
        if (goodOriginalPrice != null) {
            stmt.bindDouble(4, goodOriginalPrice);
        }
 
        Double goodStore = entity.getGoodStore();
        if (goodStore != null) {
            stmt.bindDouble(5, goodStore);
        }
 
        Double goodStoreWarningNum = entity.getGoodStoreWarningNum();
        if (goodStoreWarningNum != null) {
            stmt.bindDouble(6, goodStoreWarningNum);
        }
 
        Double goodProfit = entity.getGoodProfit();
        if (goodProfit != null) {
            stmt.bindDouble(7, goodProfit);
        }
 
        Boolean goodStatus = entity.getGoodStatus();
        if (goodStatus != null) {
            stmt.bindLong(8, goodStatus ? 1L: 0L);
        }
 
        String goodCode = entity.getGoodCode();
        if (goodCode != null) {
            stmt.bindString(9, goodCode);
        }
 
        String goodPinyinCode = entity.getGoodPinyinCode();
        if (goodPinyinCode != null) {
            stmt.bindString(10, goodPinyinCode);
        }
 
        Integer goodLoaction = entity.getGoodLoaction();
        if (goodLoaction != null) {
            stmt.bindLong(11, goodLoaction);
        }
 
        Double vipLevelOnePrice = entity.getVipLevelOnePrice();
        if (vipLevelOnePrice != null) {
            stmt.bindDouble(12, vipLevelOnePrice);
        }
 
        Double vipLevelTwoPrice = entity.getVipLevelTwoPrice();
        if (vipLevelTwoPrice != null) {
            stmt.bindDouble(13, vipLevelTwoPrice);
        }
 
        Double vipLevelThreePrice = entity.getVipLevelThreePrice();
        if (vipLevelThreePrice != null) {
            stmt.bindDouble(14, vipLevelThreePrice);
        }
 
        Double vipLevelFourthPrice = entity.getVipLevelFourthPrice();
        if (vipLevelFourthPrice != null) {
            stmt.bindDouble(15, vipLevelFourthPrice);
        }
 
        Double vipLevelFivePrice = entity.getVipLevelFivePrice();
        if (vipLevelFivePrice != null) {
            stmt.bindDouble(16, vipLevelFivePrice);
        }
 
        String goodBriefIntroduction = entity.getGoodBriefIntroduction();
        if (goodBriefIntroduction != null) {
            stmt.bindString(17, goodBriefIntroduction);
        }
 
        String goodRemarks = entity.getGoodRemarks();
        if (goodRemarks != null) {
            stmt.bindString(18, goodRemarks);
        }
 
        Boolean isSelect = entity.getIsSelect();
        if (isSelect != null) {
            stmt.bindLong(19, isSelect ? 1L: 0L);
        }
 
        Boolean isAllSelect = entity.getIsAllSelect();
        if (isAllSelect != null) {
            stmt.bindLong(20, isAllSelect ? 1L: 0L);
        }
 
        Double num = entity.getNum();
        if (num != null) {
            stmt.bindDouble(21, num);
        }
 
        String typeName = entity.getTypeName();
        if (typeName != null) {
            stmt.bindString(22, typeName);
        }
 
        Integer sort = entity.getSort();
        if (sort != null) {
            stmt.bindLong(23, sort);
        }
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
            cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2), // goodPrice
            cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3), // goodOriginalPrice
            cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4), // goodStore
            cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5), // goodStoreWarningNum
            cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6), // goodProfit
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // goodStatus
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // goodCode
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // goodPinyinCode
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // goodLoaction
            cursor.isNull(offset + 11) ? null : cursor.getDouble(offset + 11), // vipLevelOnePrice
            cursor.isNull(offset + 12) ? null : cursor.getDouble(offset + 12), // vipLevelTwoPrice
            cursor.isNull(offset + 13) ? null : cursor.getDouble(offset + 13), // vipLevelThreePrice
            cursor.isNull(offset + 14) ? null : cursor.getDouble(offset + 14), // vipLevelFourthPrice
            cursor.isNull(offset + 15) ? null : cursor.getDouble(offset + 15), // vipLevelFivePrice
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // goodBriefIntroduction
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // goodRemarks
            cursor.isNull(offset + 18) ? null : cursor.getShort(offset + 18) != 0, // isSelect
            cursor.isNull(offset + 19) ? null : cursor.getShort(offset + 19) != 0, // isAllSelect
            cursor.isNull(offset + 20) ? null : cursor.getDouble(offset + 20), // num
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // typeName
            cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22) // sort
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GoodsInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGoodName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setGoodPrice(cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2));
        entity.setGoodOriginalPrice(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setGoodStore(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        entity.setGoodStoreWarningNum(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setGoodProfit(cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6));
        entity.setGoodStatus(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setGoodCode(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setGoodPinyinCode(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setGoodLoaction(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setVipLevelOnePrice(cursor.isNull(offset + 11) ? null : cursor.getDouble(offset + 11));
        entity.setVipLevelTwoPrice(cursor.isNull(offset + 12) ? null : cursor.getDouble(offset + 12));
        entity.setVipLevelThreePrice(cursor.isNull(offset + 13) ? null : cursor.getDouble(offset + 13));
        entity.setVipLevelFourthPrice(cursor.isNull(offset + 14) ? null : cursor.getDouble(offset + 14));
        entity.setVipLevelFivePrice(cursor.isNull(offset + 15) ? null : cursor.getDouble(offset + 15));
        entity.setGoodBriefIntroduction(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setGoodRemarks(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setIsSelect(cursor.isNull(offset + 18) ? null : cursor.getShort(offset + 18) != 0);
        entity.setIsAllSelect(cursor.isNull(offset + 19) ? null : cursor.getShort(offset + 19) != 0);
        entity.setNum(cursor.isNull(offset + 20) ? null : cursor.getDouble(offset + 20));
        entity.setTypeName(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setSort(cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22));
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
    
}
