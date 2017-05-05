package org.jnosql.diana.infrastructure.database.column;

import org.jnosql.diana.api.column.ColumnConfiguration;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerFactory;
import org.jnosql.diana.cassandra.column.CassandraConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class ColumnFamilyManagerConfiguration {

    private ColumnFamilyManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        ColumnConfiguration configuration = new CassandraConfiguration();
        managerFactory = configuration.get();
    }

    @Bean
    public ColumnFamilyManagerFactory columnFamilyManagerFactory() {
        return managerFactory;
    }

    @Bean
    public ColumnFamilyManager columnFamilyManager() {
        return managerFactory.get("postman");
    }

    @PreDestroy
    public void destroy() {
        managerFactory.close();
    }
}
