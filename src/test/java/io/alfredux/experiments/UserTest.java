package io.alfredux.experiments;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static com.datastax.driver.mapping.Mapper.Option.ifNotExists;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;

@Slf4j
public class UserTest {

    private User user1;
    private User user2;
    private Mapper<User> mapper;
    private MappingManager manager;
    private Session session;

    @Before
    public void setUp() {
        session = Client.getSession("test");
        manager = new MappingManager(session);
        mapper = manager.mapper(User.class);
        user1 = new User(UUID.nameUUIDFromBytes("paco".getBytes()), "paco", 30, asList("paquito", "paquete"));
        user2 = new User(UUID.nameUUIDFromBytes("paco".getBytes()), "pepe", 25, asList("paquin"));
        log.info("user1:{} ", user1);
        log.info("user2:{} ", user2);
    }

    @Test
    public void overwriteExistingUserShouldNotBeApplied() {
        mapper.save(user1);
        Statement saveQuery = mapper.saveQuery(user2, ifNotExists(true));
        ResultSet resultSet = session.execute(saveQuery);
        assertFalse(resultSet.wasApplied());
    }

}
