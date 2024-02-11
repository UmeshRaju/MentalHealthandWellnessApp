package com.example.mentalhealthandwellnessapp;

import android.net.Uri;
import android.provider.BaseColumns;

// UserProfileContract.java
public final class UserProfileContract {
    private UserProfileContract() {} // Private constructor to prevent instantiation

    public static final String CONTENT_AUTHORITY = "com.example.mentalhealthandwellnessapp.UserProfileContract";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_USER_PROFILE = "user_profile";

    public static final class UserProfileEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_USER_PROFILE);

        public static final String TABLE_NAME = "users";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
        // Add more columns as needed
    }
}

