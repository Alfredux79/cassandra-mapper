package io.alfredux.experiments;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Client {

    public static Session getSession(String keyspace) {

        Cluster cluster = Cluster.builder()
                .withoutMetrics()
                .withClusterName("cassandra-dev")
                .addContactPoint("localhost")
                .build();

        return cluster.connect(keyspace);
    }

}
