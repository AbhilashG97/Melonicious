package abhilash.example.com.melonicious.dashboard;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class DashboardViewModelFactory implements ViewModelProvider.Factory {

    private String mUsername;

    public  DashboardViewModelFactory(String username) {
        mUsername = username;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DashboardViewModel(mUsername);
    }
}
