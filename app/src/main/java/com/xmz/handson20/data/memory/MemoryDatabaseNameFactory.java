package com.xmz.handson20.data.memory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xmz.handson20.data.memory.MemoryPersistenceContract.MemoryEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xmz on 2016/7/8.
 */
public class MemoryDatabaseNameFactory {
    public static final String memoryDatabaseName = "database";

    private static final String mDefaultDatabaseName = "database00";

    private static MemoryDatabaseNameFactory INSTANCE;

    private MemoryDbHelper mMemoryDbHelper;

    public static MemoryDatabaseNameFactory getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = new MemoryDatabaseNameFactory(context);
        }
        return INSTANCE;
    }

    private MemoryDatabaseNameFactory(Context context) {
        mMemoryDbHelper = new MemoryDbHelper(context);
    }

    public static String getDefaultDatabaseName() {
        return mDefaultDatabaseName;
    }

    public boolean saveMemory(String memoryName) {
        SQLiteDatabase db = mMemoryDbHelper.getWritableDatabase();
        if (true) {
            ContentValues values = new ContentValues();
            values.put(MemoryEntry.COLUMN_NAME_DATABASE_NAME, memoryName);
            db.insert(MemoryEntry.TABLE_NAME, null, values);
        }

        db.close();

        return true;
    }

    public boolean isContain(String memoryName) {
        SQLiteDatabase db = mMemoryDbHelper.getReadableDatabase();
        String [] projection = {
                MemoryEntry.COLUMN_NAME_DATABASE_NAME
        };

        String selection = MemoryEntry.COLUMN_NAME_DATABASE_NAME + " LIKE ? ";
        String [] selectionArgs = { memoryName };

        Cursor c = db.query(MemoryEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        if (c != null && c.getCount() > 0) {
            c.close();
            db.close();
            return true;
        } else {
            db.close();
            return false;
        }
    }

    public void deleteMemory(String memoryName) {
        SQLiteDatabase db = mMemoryDbHelper.getWritableDatabase();
        String selection = MemoryEntry.COLUMN_NAME_DATABASE_NAME + " LIKE ?";
        String [] selectionArgs = {
                memoryName
        };
        db.delete(MemoryEntry.TABLE_NAME, selection, selectionArgs);
        db.close();
    }

    public List<String> getAllMemoryName() {
        List<String> allMemoryName = new ArrayList<String>();
        SQLiteDatabase db = mMemoryDbHelper.getReadableDatabase();
        String [] projection = {
                MemoryEntry.COLUMN_NAME_DATABASE_NAME
        };

        Cursor c = db.query(MemoryEntry.TABLE_NAME, projection, null, null, null, null, null);
        if(c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String databaseName = c.getString(c.getColumnIndexOrThrow(MemoryEntry.COLUMN_NAME_DATABASE_NAME));
                allMemoryName.add(databaseName);
            }
        }

        if (c != null) {
            c.close();
        }
        db.close();

        return allMemoryName;
    }
}
