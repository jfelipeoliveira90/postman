package org.jnosql.diana.domain.model;

import org.jnosql.diana.api.column.ColumnEntity;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {
    private static final String COLUMN_NAME = "notifications";

    @Autowired
    private ColumnFamilyManager manager;

    @Override
    public void save(Notification notification) {
        manager.save(ColumnEntity.of(COLUMN_NAME, notification.toColumn()));
    }
}
