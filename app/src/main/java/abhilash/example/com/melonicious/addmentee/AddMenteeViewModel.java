package abhilash.example.com.melonicious.addmentee;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import abhilash.example.com.melonicious.model.Mentee;

public class AddMenteeViewModel extends AndroidViewModel {

    private LiveData<Mentee> menteeLiveData;
    private AddMenteeRepository mAddMenteeRepository;

    public AddMenteeViewModel(@NonNull Application application) {
        super(application);
        Context context = application.getApplicationContext();
        menteeLiveData = new MutableLiveData<>();
        mAddMenteeRepository = AddMenteeRepository.getInstance(context);
    }

    public void setMenteeLiveData(String username, List<String> interests, List<String> skillset) {
        menteeLiveData = mAddMenteeRepository.getGitHubUser(username, interests, skillset);
    }

    public LiveData<Mentee> getMenteeObservable() {
        return  menteeLiveData;
    }

}
