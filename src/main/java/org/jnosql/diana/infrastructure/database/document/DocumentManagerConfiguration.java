package org.jnosql.diana.infrastructure.database.document;

import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.api.document.DocumentConfiguration;
import org.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class DocumentManagerConfiguration {

    private DocumentCollectionManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        DocumentConfiguration configuration = new MongoDBDocumentConfiguration();
        managerFactory = configuration.get();
    }

    @Bean
    public DocumentCollectionManagerFactory documentCollectionManagerFactory() {
        return managerFactory;
    }

    @Bean
    public DocumentCollectionManager documentCollectionManager() {
        return managerFactory.get("postman");
    }

    @PreDestroy
    public void destroy() {
        managerFactory.close();
    }
}
