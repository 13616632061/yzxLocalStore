package com.yzx.yzxlocalstore.entity;

import com.yzx.yzxlocalstore.constant.Constants;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.TypeBeanDao;
import com.yzx.yzxlocalstore.greendao.UserDao;

/**
 * Created by lyf on 2019/4/30.
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;//用户id
    @Unique
    private String number;//工号
    private String name;//姓名
    private String phone;//手机号码
    private int level;//用户等级 0表示商户 1表示员工
    private boolean status;//账号状态
    private double salesCommission;//销售提成
    private boolean isShowBuyingPrice;//是否显示进货价
    private boolean isShowBuyingProfit;//是否显示利润
    private boolean isShowBuyingStore;//是否显示库存
    private String pwd;//用户密码
    @ToMany(referencedJoinProperty = "id")
    private List<TypeBean> typeBeanList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 1560097334)
    public User(Long id, String number, String name, String phone, int level, boolean status,
                double salesCommission, boolean isShowBuyingPrice, boolean isShowBuyingProfit,
                boolean isShowBuyingStore, String pwd) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.phone = phone;
        this.level = level;
        this.status = status;
        this.salesCommission = salesCommission;
        this.isShowBuyingPrice = isShowBuyingPrice;
        this.isShowBuyingProfit = isShowBuyingProfit;
        this.isShowBuyingStore = isShowBuyingStore;
        this.pwd = pwd;
    }

    @Generated(hash = 586692638)
    public User() {
    }


    public double getSalesCommission() {
        return salesCommission;
    }

    public void setSalesCommission(double salesCommission) {
        this.salesCommission = salesCommission;
    }

    public boolean isShowBuyingPrice() {
        return isShowBuyingPrice;
    }

    public void setShowBuyingPrice(boolean showBuyingPrice) {
        isShowBuyingPrice = showBuyingPrice;
    }

    public boolean isShowBuyingProfit() {
        return isShowBuyingProfit;
    }

    public void setShowBuyingProfit(boolean showBuyingProfit) {
        isShowBuyingProfit = showBuyingProfit;
    }

    public boolean isShowBuyingStore() {
        return isShowBuyingStore;
    }

    public void setShowBuyingStore(boolean showBuyingStore) {
        isShowBuyingStore = showBuyingStore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public boolean getIsShowBuyingPrice() {
        return this.isShowBuyingPrice;
    }

    public void setIsShowBuyingPrice(boolean isShowBuyingPrice) {
        this.isShowBuyingPrice = isShowBuyingPrice;
    }

    public boolean getIsShowBuyingProfit() {
        return this.isShowBuyingProfit;
    }

    public void setIsShowBuyingProfit(boolean isShowBuyingProfit) {
        this.isShowBuyingProfit = isShowBuyingProfit;
    }

    public boolean getIsShowBuyingStore() {
        return this.isShowBuyingStore;
    }

    public void setIsShowBuyingStore(boolean isShowBuyingStore) {
        this.isShowBuyingStore = isShowBuyingStore;
    }

    /**
     * 角色名称
     *
     * @return
     */
    public String getRoles() {
        if (level == 0) {
            return Constants.STAFFER_ROLES[0];
        } else {
            return Constants.STAFFER_ROLES[1];
        }
    }

    /**
     * 状态名称
     *
     * @return
     */
    public String getStatusName() {
        if (status) {
            return Constants.STAFFER_STATUS[0];
        } else {
            return Constants.STAFFER_STATUS[1];
        }
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2038591152)
    public List<TypeBean> getTypeBeanList() {
        if (typeBeanList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypeBeanDao targetDao = daoSession.getTypeBeanDao();
            List<TypeBean> typeBeanListNew = targetDao._queryUser_TypeBeanList(id);
            synchronized (this) {
                if (typeBeanList == null) {
                    typeBeanList = typeBeanListNew;
                }
            }
        }
        return typeBeanList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1076114045)
    public synchronized void resetTypeBeanList() {
        typeBeanList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
