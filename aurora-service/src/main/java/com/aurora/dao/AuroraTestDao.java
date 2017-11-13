package com.aurora.dao;

import com.aurora.po.AuroraTestTablePO;

/**
 * Created by zhangjian49 on 2017/9/25.
 */
public interface AuroraTestDao {
    int insert(AuroraTestTablePO po);

    AuroraTestTablePO findTestEntity(Long id);
}
