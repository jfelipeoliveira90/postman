package org.jnosql.diana.domain.service.impl;

import org.jnosql.diana.domain.model.Notification;
import org.jnosql.diana.domain.model.NotificationRepository;
import org.jnosql.diana.domain.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Override
    public void save(Notification notification) {
        repository.save(notification);
    }
}
