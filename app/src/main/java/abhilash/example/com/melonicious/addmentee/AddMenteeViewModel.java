package abhilash.example.com.melonicious.addmentee;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import abhilash.example.com.melonicious.model.Mentee;

public class AddMenteeViewModel extends ViewModel {

    private LiveData<Mentee> menteeLiveData;

    public AddMenteeViewModel() {
        menteeLiveData = null;
    }

    public AddMenteeViewModel(String username) {
        menteeLiveData = AddMenteeRepository.getInstance().getGitHubUser(username);
    }

    public LiveData<Mentee> getMenteeObservable() {
        return  menteeLiveData;
    }
}
