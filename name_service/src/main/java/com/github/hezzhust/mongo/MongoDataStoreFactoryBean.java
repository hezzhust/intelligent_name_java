package com.github.hezzhust.mongo;

import com.mongodb.*;
import lombok.Data;
import org.mongodb.morphia.AdvancedDatastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.MapperOptions;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * Created by hezz on 2017/7/10.
 */
@Data
public class MongoDataStoreFactoryBean implements InitializingBean, DisposableBean, FactoryBean<AdvancedDatastore> {

    private MongoClient mongoClient;
    private MongoClientOptions.Builder builder;
    private String mapName;
    private String mongoServer;
    private String dbName;
    private WriteConcern writeConcern = WriteConcern.ACKNOWLEDGED;
    private int minConnectionsPerHost = 10;
    private int maxConnectionsPerHost = 100;
    private int threadsAllowedToBlockForConnectionMultiplier = 5;
    private int maxWaitTime = 120000;
    private int maxConnectionIdleTime = 0;//0表示不限制
    private int maxConnectionLifeTime = 0;//0表示不限制
    private int connectTimeout = 5000;
    private int socketTimeout = 10000;
    private boolean socketKeepAlive = false;
    private String readPreference = "primary";
    private boolean enableBulkWrite = false;
    private Morphia morphia = new Morphia();
    private boolean ignoreInvalidClasses = false;
    private boolean storeEmpties = false;
    private boolean storeNulls = false;
    private boolean toEnsureIndexes = false;
    private boolean toEnsureCaps = false;

    private AdvancedDatastore datastore;



    public AdvancedDatastore getObject() throws Exception {
        return datastore;
    }

    public Class<?> getObjectType() {
        return AdvancedDatastore.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() throws Exception {
        builder = new MongoClientOptions.Builder();
        builder.socketKeepAlive(socketKeepAlive)
                .maxWaitTime(maxWaitTime)
                .minConnectionsPerHost(minConnectionsPerHost)
                .connectionsPerHost(maxConnectionsPerHost)
                .connectTimeout(connectTimeout)
                .socketTimeout(socketTimeout)
                .maxConnectionIdleTime(maxConnectionIdleTime)
                .maxConnectionLifeTime(maxConnectionLifeTime)
                .threadsAllowedToBlockForConnectionMultiplier(threadsAllowedToBlockForConnectionMultiplier)
                .writeConcern(writeConcern)
                .readPreference(ReadPreference.valueOf(readPreference));


//        morphia.setUseBulkWriteOperations(enableBulkWrite);
        MapperOptions options = morphia.mapPackage(mapName, ignoreInvalidClasses).getMapper().getOptions();
        options.setStoreEmpties(storeEmpties);
        options.setStoreNulls(storeNulls);
        MongoClientURI uri = new MongoClientURI(mongoServer, builder);
        mongoClient =  new MongoClient(uri);
//        datastore = new DatastoreImpl(morphia, mongoClient, dbName);
        datastore = (AdvancedDatastore) morphia.createDatastore(mongoClient, dbName);
        if(toEnsureIndexes){
            datastore.ensureIndexes();
        }
        if(toEnsureCaps){
            datastore.ensureCaps();
        }

    }

    public void destroy() throws Exception {
        if(null!=mongoClient){
            mongoClient.close();
        }
    }
}
