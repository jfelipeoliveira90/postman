package org.jnosql.diana.domain.service.impl;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jnosql.diana.domain.exceptions.TemplateNotFoundException;
import org.jnosql.diana.domain.model.Notification;
import org.jnosql.diana.domain.model.NotificationRepository;
import org.jnosql.diana.domain.model.Template;
import org.jnosql.diana.domain.model.TemplateRepository;
import org.jnosql.diana.domain.service.NotificationService;
import org.jnosql.diana.interfaces.web.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Optional;

import static org.apache.cassandra.utils.UUIDGen.getTimeUUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public void save(NotificationRequest request) {
        Notification notification = new Notification.Builder()
                .withFrom(request.getFrom())
                .withTo(request.getTo())
                .withSubject(request.getSubject())
                .withBody(generateBody(request))
                .withUUID(getTimeUUID())
                .build();

        notificationRepository.save(notification);
    }

    private String generateBody(NotificationRequest request) {
        VelocityContext velocityContext = new VelocityContext(request.getParams());
        StringWriter body = new StringWriter();
        Optional<Template> template = templateRepository.findByToken(request.getTemplateToken());

        Velocity.evaluate(velocityContext, body, "template", template.map(Template::getLayout)
                .orElseThrow(TemplateNotFoundException::new));

        return body.toString();
    }
}
