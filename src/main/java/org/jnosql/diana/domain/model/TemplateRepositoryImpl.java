package org.jnosql.diana.domain.model;

import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCondition;
import org.jnosql.diana.api.document.DocumentEntity;
import org.jnosql.diana.api.document.DocumentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

    @Autowired
    private DocumentCollectionManager manager;

    @Override
    public Optional<Template> findByToken(String token) {
        DocumentQuery query = DocumentQuery.of("templates")
                .with(DocumentCondition.eq(Document.of("token", token)));

        List<Document> documents = manager.singleResult(query)
                .map(DocumentEntity::getDocuments)
                .orElse(emptyList());

        return Optional.ofNullable(
                new Template.Builder()
                        .withId(documents.get(0).getValue().toString())
                        .withToken(documents.get(1).getValue().toString())
                        .withLayout(documents.get(2).getValue().get(String.class))
                        .build());
    }
}
