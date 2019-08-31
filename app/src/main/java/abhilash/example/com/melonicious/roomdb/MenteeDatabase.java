package abhilash.example.com.melonicious.roomdb;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import abhilash.example.com.melonicious.model.Mentee;

@Database(entities = {Mentee.class}, version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class MenteeDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
