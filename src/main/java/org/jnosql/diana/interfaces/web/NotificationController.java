package org.jnosql.diana.interfaces.web;

import org.jnosql.diana.domain.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody NotificationRequest request) {
        service.save(request);

        return noContent().build();
    }
}
