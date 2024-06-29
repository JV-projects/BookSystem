package com.booksystem.booksystem.config.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;

//@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {




    @Override
    protected String getDatabaseName() {
        return "booksystem";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
