package io.alfredux.experiments;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Table(keyspace = "test", name = "user")
public class User {

    @PartitionKey
    private UUID id;
    private String name;
    protected Integer age;
    private List<String> nickNames;

}
