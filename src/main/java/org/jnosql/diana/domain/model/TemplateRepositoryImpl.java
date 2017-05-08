package org.jnosql.diana.domain.model;

import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCondition;
import org.jnosql.diana.api.document.DocumentEntity;
import org.jnosql.diana.api.document.DocumentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Optional;

@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

    @Autowired
    private DocumentCollectionManager manager;

    @Override
    public Optional<Template> findByToken(String token) {
        DocumentQuery query = DocumentQuery.of("templates")
                .with(DocumentCondition.eq(Document.of("token", token)));

        manager.singleResult(query)
                .map(DocumentEntity::getDocuments)
                .orElse(Collections.emptyList())
                .forEach(System.out::println);

        return Optional.empty();
    }
}
