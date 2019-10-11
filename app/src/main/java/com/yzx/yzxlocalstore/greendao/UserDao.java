package com.yzx.yzxlocalstore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yzx.yzxlocalstore.entity.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Number = new Property(1, String.class, "number", false, "NUMBER");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Phone = new Property(3, String.class, "phone", false, "PHONE");
        public final static Property Level = new Property(4, Integer.class, "level", false, "LEVEL");
        public final static Property Status = new Property(5, Boolean.class, "status", false, "STATUS");
        public final static Property SalesCommission = new Property(6, Double.class, "salesCommission", false, "SALES_COMMISSION");
        public final static Property IsShowBuyingPrice = new Property(7, Boolean.class, "isShowBuyingPrice", false, "IS_SHOW_BUYING_PRICE");
        public final static Property IsShowBuyingProfit = new Property(8, Boolean.class, "isShowBuyingProfit", false, "IS_SHOW_BUYING_PROFIT");
        public final static Property IsShowBuyingStore = new Property(9, Boolean.class, "isShowBuyingStore", false, "IS_SHOW_BUYING_STORE");
        public final static Property Pwd = new Property(10, String.class, "pwd", false, "PWD");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NUMBER\" TEXT UNIQUE ," + // 1: number
                "\"NAME\" TEXT," + // 2: name
                "\"PHONE\" TEXT," + // 3: phone
                "\"LEVEL\" INTEGER," + // 4: level
                "\"STATUS\" INTEGER," + // 5: status
                "\"SALES_COMMISSION\" REAL," + // 6: salesCommission
                "\"IS_SHOW_BUYING_PRICE\" INTEGER," + // 7: isShowBuyingPrice
                "\"IS_SHOW_BUYING_PROFIT\" INTEGER," + // 8: isShowBuyingProfit
                "\"IS_SHOW_BUYING_STORE\" INTEGER," + // 9: isShowBuyingStore
                "\"PWD\" TEXT);"); // 10: pwd
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String number = entity.getNumber();
        if (number != null) {
            stmt.bindString(2, number);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(4, phone);
        }
 
        Integer level = entity.getLevel();
        if (level != null) {
            stmt.bindLong(5, level);
        }
 
        Boolean status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(6, status ? 1L: 0L);
        }
 
        Double salesCommission = entity.getSalesCommission();
        if (salesCommission != null) {
            stmt.bindDouble(7, salesCommission);
        }
 
        Boolean isShowBuyingPrice = entity.getIsShowBuyingPrice();
        if (isShowBuyingPrice != null) {
            stmt.bindLong(8, isShowBuyingPrice ? 1L: 0L);
        }
 
        Boolean isShowBuyingProfit = entity.getIsShowBuyingProfit();
        if (isShowBuyingProfit != null) {
            stmt.bindLong(9, isShowBuyingProfit ? 1L: 0L);
        }
 
        Boolean isShowBuyingStore = entity.getIsShowBuyingStore();
        if (isShowBuyingStore != null) {
            stmt.bindLong(10, isShowBuyingStore ? 1L: 0L);
        }
 
        String pwd = entity.getPwd();
        if (pwd != null) {
            stmt.bindString(11, pwd);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String number = entity.getNumber();
        if (number != null) {
            stmt.bindString(2, number);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(4, phone);
        }
 
        Integer level = entity.getLevel();
        if (level != null) {
            stmt.bindLong(5, level);
        }
 
        Boolean status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(6, status ? 1L: 0L);
        }
 
        Double salesCommission = entity.getSalesCommission();
        if (salesCommission != null) {
            stmt.bindDouble(7, salesCommission);
        }
 
        Boolean isShowBuyingPrice = entity.getIsShowBuyingPrice();
        if (isShowBuyingPrice != null) {
            stmt.bindLong(8, isShowBuyingPrice ? 1L: 0L);
        }
 
        Boolean isShowBuyingProfit = entity.getIsShowBuyingProfit();
        if (isShowBuyingProfit != null) {
            stmt.bindLong(9, isShowBuyingProfit ? 1L: 0L);
        }
 
        Boolean isShowBuyingStore = entity.getIsShowBuyingStore();
        if (isShowBuyingStore != null) {
            stmt.bindLong(10, isShowBuyingStore ? 1L: 0L);
        }
 
        String pwd = entity.getPwd();
        if (pwd != null) {
            stmt.bindString(11, pwd);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // number
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // phone
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // level
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // status
            cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6), // salesCommission
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // isShowBuyingPrice
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // isShowBuyingProfit
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0, // isShowBuyingStore
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // pwd
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNumber(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLevel(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setStatus(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setSalesCommission(cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6));
        entity.setIsShowBuyingPrice(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setIsShowBuyingProfit(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setIsShowBuyingStore(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
        entity.setPwd(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
