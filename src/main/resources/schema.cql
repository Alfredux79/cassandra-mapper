CREATE KEYSPACE test WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

CREATE TABLE test.user(
    id uuid,
    name text,
    age int,
    nicknames list<text>,
PRIMARY KEY (id));