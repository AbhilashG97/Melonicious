package abhilash.example.com.melonicious.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import abhilash.example.com.melonicious.model.Mentee;

public class DashboardViewModel extends ViewModel {

    private final LiveData<Mentee> menteeObservable;

    public DashboardViewModel() {
        menteeObservable = null;
    }

    public DashboardViewModel(String username) {
        menteeObservable = DashboardRepository.getInstance().getGitHubUser(username);
    }

    public LiveData<Mentee> getMenteeObservable() {
        return  menteeObservable;
    }

}
