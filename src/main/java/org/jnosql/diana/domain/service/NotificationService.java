package org.jnosql.diana.domain.service;

import org.jnosql.diana.interfaces.web.NotificationRequest;

public interface NotificationService {

    void save(NotificationRequest notificationRequest);
}
