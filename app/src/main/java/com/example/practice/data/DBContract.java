package com.example.practice.data;

import android.provider.BaseColumns;

public final class DBContract {

    private DBContract() {
    };

    public static final class YourScores implements BaseColumns {
        public final static String TABLE_NAME = "scores";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_DAYS = "day";
    }
}
