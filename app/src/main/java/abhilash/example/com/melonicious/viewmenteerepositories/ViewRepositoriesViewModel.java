package abhilash.example.com.melonicious.viewmenteerepositories;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import abhilash.example.com.melonicious.model.Repository;

public class ViewRepositoriesViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModelFactory to get instance of the Mentee class

    private ViewMenteeRepositoriesRepository viewMenteeRepositoriesRepository;

    public ViewRepositoriesViewModel(@NonNull Application application) {
        super(application);
        viewMenteeRepositoriesRepository = ViewMenteeRepositoriesRepository
                .getInstance(application.getApplicationContext());
    }

    public List<Repository> getRepositories() {
        return viewMenteeRepositoriesRepository.getRepositories();
    }
}