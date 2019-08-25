package abhilash.example.com.melonicious.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;

import abhilash.example.com.melonicious.model.Mentee;

@Dao
public interface DaoAccess {

    @Insert
    LiveData<Mentee> insertMentee(Mentee mentee);

}
