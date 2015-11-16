package io.github.gefangshuai.server.core.persistence;

import java.io.Serializable;

/**
 * 核心 Service 类
 * Created by gefangshuai on 2015/11/16.
 */
public abstract class CoreService<T, ID extends Serializable> {
    protected CoreDao<T, ID> coreDao;

    public T findOne(ID id) {
        return coreDao.findOne(id);
    }
}
