package com.xmz.handson20.data.memory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xmz.handson20.data.memory.MemoryPersistenceContract.MemoryEntry;

/**
 * Created by xmz on 2016/7/8.
 */
public class MemoryDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String INT_TYPE = " INTEGER";

    private static final String TEXT_TYPE = " TEXT";

    private static final String COMMA_SEP = ",";

    private static final String SQL_MEMORY_CREATE_ENTRIES =
            "CREATE TABLE " + MemoryEntry.TABLE_NAME + " (" +
                    MemoryEntry.COLUMN_NAME_ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    MemoryEntry.COLUMN_NAME_DATABASE_NAME + TEXT_TYPE +
                    " )";

    public MemoryDbHelper(Context context) {
        super(context, MemoryDatabaseNameFactory.memoryDatabaseName, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_MEMORY_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
