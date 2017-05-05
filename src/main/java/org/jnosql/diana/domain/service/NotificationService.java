package org.jnosql.diana.domain.service;

import org.jnosql.diana.domain.model.Notification;

import javax.validation.constraints.NotNull;

public interface NotificationService {

    void save(@NotNull Notification notification);
}
