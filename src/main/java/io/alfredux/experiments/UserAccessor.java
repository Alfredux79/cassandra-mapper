package io.alfredux.experiments;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

@Accessor
public interface UserAccessor {

    @Query("SELECT * FROM test.user")
    Result<User> getAllUsers();

    @Query("TRUNCATE test.user")
    void deleteAllUsers();

    @Query("SELECT count(*) FROM test.user")
    ResultSet count();

}
