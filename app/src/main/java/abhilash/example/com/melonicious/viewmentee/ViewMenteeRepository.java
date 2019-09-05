package abhilash.example.com.melonicious.viewmentee;

import android.content.Context;

import androidx.room.Room;

import abhilash.example.com.melonicious.roomdb.MenteeDatabase;

public class ViewMenteeRepository {

    private static ViewMenteeRepository viewMenteeRepository;
    private Context mContext;
    private MenteeDatabase mMenteeDatabase;

    private ViewMenteeRepository(Context context) {
        mContext = context;
        mMenteeDatabase = Room.databaseBuilder(context, MenteeDatabase.class, "Mentee")
                .build();
    }

    public static ViewMenteeRepository getIntance(Context context) {
        if (viewMenteeRepository == null) {
            viewMenteeRepository = new ViewMenteeRepository(context);
        }
        return viewMenteeRepository;
    }

}
