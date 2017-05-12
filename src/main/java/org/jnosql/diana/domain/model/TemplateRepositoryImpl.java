package org.jnosql.diana.domain.model;

import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCondition;
import org.jnosql.diana.api.document.DocumentEntity;
import org.jnosql.diana.api.document.DocumentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

    @Autowired
    private DocumentCollectionManager manager;

    @Override
    public Optional<Template> findByToken(String token) {
        DocumentQuery query = DocumentQuery.of("templates")
                .with(DocumentCondition.eq(Document.of("token", token)));

        return manager.singleResult(query)
                .map(DocumentEntity::getDocuments)
                .map(documents -> new Template.Builder()
                        .withLayout(documents.get(0).getValue().get(String.class))
                        .withToken(documents.get(1).getValue().get(String.class))
                        .build());
    }
}
