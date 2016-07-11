package com.xmz.handson20.data.memory;

/**
 * Created by xmz on 2016/7/8.
 */
public final class MemoryPersistenceContract {

    public MemoryPersistenceContract() {}

    public static abstract class MemoryEntry {
        public static final String TABLE_NAME = "memory";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_DATABASE_NAME = "database_name";
    }
}
