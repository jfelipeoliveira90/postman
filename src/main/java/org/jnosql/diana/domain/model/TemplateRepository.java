package org.jnosql.diana.domain.model;

import java.util.Optional;

public interface TemplateRepository {

    Optional<Template> findByToken(String token);
}
