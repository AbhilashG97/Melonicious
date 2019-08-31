package abhilash.example.com.melonicious.addmentee;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import abhilash.example.com.melonicious.model.Mentee;
import abhilash.example.com.melonicious.retrofit.RetrofitInstance;
import abhilash.example.com.melonicious.retrofit.RetrofitService;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddMenteeRepository {
    private RetrofitService service;
    private Mentee mMentee;

    private static AddMenteeRepository addMenteeRepository;

    private AddMenteeRepository() {
        mMentee = new Mentee();
        service = RetrofitInstance.getRetrofit().create(RetrofitService.class);
    }

    public static AddMenteeRepository getInstance() {
        if (addMenteeRepository == null) {
            addMenteeRepository = new AddMenteeRepository();
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
                                data.postValue(mentee);
                                Log.i("Fetched Mentee", mentee.toString());
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

}
