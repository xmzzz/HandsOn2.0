package com.xmz.handson20.data;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xmz on 2016/7/11.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";

    private static final String  INT_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_SOCKET_CREATE_ENTRIES =
            "CREATE TABLE " + Device
}
