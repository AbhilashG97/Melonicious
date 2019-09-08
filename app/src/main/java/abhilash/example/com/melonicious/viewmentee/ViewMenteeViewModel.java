package abhilash.example.com.melonicious.viewmentee;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import abhilash.example.com.melonicious.model.Mentee;

public class ViewMenteeViewModel extends AndroidViewModel {

    private ViewMenteeRepository viewMenteeRepository;
    private MutableLiveData<List<Mentee>> menteeListLiveData;

    public ViewMenteeViewModel(@NonNull Application application) {
        super(application);
        viewMenteeRepository = ViewMenteeRepository.getIntance(application.getBaseContext());
        menteeListLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Mentee>> getAllMentees() {
        menteeListLiveData.setValue(viewMenteeRepository.getMenteeList());
        return menteeListLiveData;
    }

    public List<Mentee> getMenteeList() {

        List<Mentee> mentees = viewMenteeRepository.getMenteeList();

        Log.i("MENTEE LIST VM", mentees.toString());

        return mentees;
    }


}
