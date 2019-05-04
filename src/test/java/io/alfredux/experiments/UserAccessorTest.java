package io.alfredux.experiments;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@Slf4j
public class UserAccessorTest {

    private UserAccessor accessor;
    private Mapper<User> mapper;

    @Before
    public void setUp() {
        MappingManager manager = new MappingManager(Client.getSession("test"));
        mapper = manager.mapper(User.class);
        accessor = manager.createAccessor(UserAccessor.class);
        accessor.deleteAllUsers();
    }

    @Test
    public void accessorTestAllMethods() {
        mapper.save(new User(UUID.randomUUID(), "paco", 15, ImmutableList.<String>of()));
        assertEquals(1L, accessor.count().one().getLong(0));
        accessor.deleteAllUsers();
        assertEquals(0, accessor.getAllUsers().all().size());
    }

}
