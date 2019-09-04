package abhilash.example.com.melonicious.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import abhilash.example.com.melonicious.model.Mentee;

@Dao
public interface DaoAccess {

    @Insert
    void insertMentee(Mentee mentee);

    @Query("SELECT id from Mentee WHERE id = :id")
    Integer getMenteeID(Integer id);

    @Query("Select * from Mentee")
    LiveData<List<Mentee>> getAllMentees();

}
