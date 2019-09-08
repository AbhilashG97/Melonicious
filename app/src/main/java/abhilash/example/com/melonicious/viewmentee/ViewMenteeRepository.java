package abhilash.example.com.melonicious.viewmentee;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import abhilash.example.com.melonicious.model.Mentee;
import abhilash.example.com.melonicious.roomdb.DaoAccess;
import abhilash.example.com.melonicious.roomdb.MenteeDatabase;

public class ViewMenteeRepository {

    private static ViewMenteeRepository viewMenteeRepository;
    private MenteeDatabase mMenteeDatabase;
    private volatile List<Mentee> menteeList;
    private MutableLiveData<List<Mentee>> menListMutableLiveData;

    private ViewMenteeRepository(Context context) {
        mMenteeDatabase = Room.databaseBuilder(context, MenteeDatabase.class, "Mentee")
                .build();
    }

    public static ViewMenteeRepository getIntance(Context context) {
        if (viewMenteeRepository == null) {
            viewMenteeRepository = new ViewMenteeRepository(context);
        }
        return viewMenteeRepository;
    }

    public List<Mentee> getMenteeList() {
        DaoAccess daoAccess = mMenteeDatabase.daoAccess();
        menteeList = new ArrayList<>();
        menListMutableLiveData = new MutableLiveData<>();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<List<Mentee>> future = executorService.submit(new Callable<List<Mentee>>() {
            @Override
            public List<Mentee> call() throws Exception {
                return daoAccess.getAllMentees();
            }
        });

        try {
            menteeList = future.get();
            Log.i("REPOSITORY FETCH IS", menteeList.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        Log.i("REPOSITORY FETCH OS", menteeList.toString());

        return menteeList;
    }
}
