package com.platform.app.data.mapper;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.platform.app.data.dao.Address;
import com.platform.app.data.dao.User;

import com.platform.app.data.mapper.AddressDao;
import com.platform.app.data.mapper.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig addressDaoConfig;
    private final DaoConfig userDaoConfig;

    private final AddressDao addressDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        addressDaoConfig = daoConfigMap.get(AddressDao.class).clone();
        addressDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        addressDao = new AddressDao(addressDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Address.class, addressDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        addressDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}