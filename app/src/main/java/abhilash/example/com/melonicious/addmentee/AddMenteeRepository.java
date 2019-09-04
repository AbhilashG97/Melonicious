package abhilash.example.com.melonicious.addmentee;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.List;

import abhilash.example.com.melonicious.model.Mentee;
import abhilash.example.com.melonicious.retrofit.RetrofitInstance;
import abhilash.example.com.melonicious.retrofit.RetrofitService;
import abhilash.example.com.melonicious.roomdb.DaoAccess;
import abhilash.example.com.melonicious.roomdb.MenteeDatabase;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddMenteeRepository {
    private RetrofitService service;
    private Mentee mMentee;
    private Context mContext;

    private MenteeDatabase mMenteeDatabase;
    private static AddMenteeRepository addMenteeRepository;


    private AddMenteeRepository(Context context) {
        mMentee = new Mentee();
        mContext = context;
        service = RetrofitInstance.getRetrofit().create(RetrofitService.class);
        mMenteeDatabase = Room.databaseBuilder(mContext, MenteeDatabase.class, "Mentee")
                .build();
    }


    public static AddMenteeRepository getInstance(Context context) {
        if (addMenteeRepository == null) {
            addMenteeRepository = new AddMenteeRepository(context);
        }
        return addMenteeRepository;
    }

    public LiveData<Mentee> getGitHubUser(String username,
                                          List<String> interests,
                                          List<String> skillset) {
        final MutableLiveData<Mentee> data = new MutableLiveData<>();

        Observable<Mentee> menteeObservable = service.getMentee(username);
        menteeObservable.subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.newThread())
                        .subscribe(new Observer<Mentee>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Mentee mentee) {
                                mMentee = mentee;
                                mMentee.setInterests(interests);
                                mMentee.setSkillsets(skillset);
                                Log.i("Fetched Mentee", mentee.toString());
                                data.postValue(mentee);
                                insertTask(mentee);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
        return data;
    }

    public void insertTask(final Mentee mentee) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                DaoAccess daoAccess =  mMenteeDatabase.daoAccess();
                if(daoAccess.getMenteeID(mentee.getId()) != null) {
                    Log.i("MENTEE ALREADY EXISTS", mentee.getId().toString());
                } else {
                    daoAccess.insertMentee(mentee);
                    Log.i("INSERTED MENTEE", mentee.toString());
                }
                return null;
            }
        }.execute();
    }
}
