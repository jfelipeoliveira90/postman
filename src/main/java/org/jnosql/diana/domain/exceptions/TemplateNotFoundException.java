package org.jnosql.diana.domain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND, reason = "Template not found.")
public class TemplateNotFoundException extends RuntimeException {

}
