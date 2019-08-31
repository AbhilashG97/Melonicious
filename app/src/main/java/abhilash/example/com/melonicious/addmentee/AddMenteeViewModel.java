package abhilash.example.com.melonicious.addmentee;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import abhilash.example.com.melonicious.model.Mentee;

public class AddMenteeViewModel extends ViewModel {

    private LiveData<Mentee> menteeLiveData;
    private AddMenteeRepository mAddMenteeRepository;

    public AddMenteeViewModel() {
        menteeLiveData = new MutableLiveData<>();
        mAddMenteeRepository = AddMenteeRepository.getInstance();
    }

    public void setMenteeLiveData(String username, List<String> interests, List<String> skillset) {
        menteeLiveData = mAddMenteeRepository.getGitHubUser(username, interests, skillset);
    }

    public LiveData<Mentee> getMenteeObservable() {
        return  menteeLiveData;
    }

}
