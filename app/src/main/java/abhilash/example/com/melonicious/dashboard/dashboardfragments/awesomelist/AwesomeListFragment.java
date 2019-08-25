package abhilash.example.com.melonicious.dashboard.dashboardfragments.awesomelist;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import abhilash.example.com.melonicious.R;

public class AwesomeListFragment extends Fragment {

    private AwesomeListViewModel mViewModel;

    public static AwesomeListFragment newInstance() {
        return new AwesomeListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.awesome_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AwesomeListViewModel.class);
        // TODO: Use the ViewModel
    }

}
