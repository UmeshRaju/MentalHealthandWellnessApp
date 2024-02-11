package com.example.mentalhealthandwellnessapp;

import static com.example.mentalhealthandwellnessapp.UserProfileContract.CONTENT_AUTHORITY;
import static com.example.mentalhealthandwellnessapp.UserProfileContract.PATH_USER_PROFILE;
import static com.example.mentalhealthandwellnessapp.UserProfileContract.UserProfileEntry.TABLE_NAME;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// UserProfileProvider.java


public class UserProfileProvider extends ContentProvider {


    private UserProfileDbHelper userProfileDbHelper;
    private static final String TAG = UserProfileProvider.class.getSimpleName();
    private static final int USERS = 1;				// For whole table
    private static final int USERS_ID = 2;			// For a specific row in a table identified by _ID
    private static final int USERS_ID_NAME = 3;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_USER_PROFILE, USERS);
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_USER_PROFILE + "/#", USERS_ID);
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_USER_PROFILE + "/*", USERS_ID_NAME);
    }

    public SQLiteOpenHelper userProfileDbHealper;

    public UserProfileProvider(UserProfileDbHelper userProfileDbHelper) {
        this.userProfileDbHelper = userProfileDbHelper;
    }


    @Override
    public boolean onCreate() {
        userProfileDbHelper = new UserProfileDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteDatabase database = userProfileDbHealper.getReadableDatabase();
        Cursor cursor;

        switch (uriMatcher.match(uri)) {

            case USERS:
                cursor = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            case USERS_ID:
                selection = UserProfileContract.UserProfileEntry._ID + " = ?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
        }

        return cursor;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {

        if (uriMatcher.match(uri) == USERS) {
            return insertRecord(uri, values);
        }
        throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
    }

    private Uri insertRecord(Uri uri, ContentValues values) {

        SQLiteDatabase database = userProfileDbHelper.getWritableDatabase();
        long rowId = database.insert(UserProfileContract.UserProfileEntry.TABLE_NAME, null, values);

        if (rowId == -1) {
            Log.e(TAG, "Insert error for URI " + uri);
            return null;
        }

        return ContentUris.withAppendedId(uri, rowId);
    }
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {

        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}