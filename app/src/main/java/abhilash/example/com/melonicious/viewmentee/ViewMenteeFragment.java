package abhilash.example.com.melonicious.viewmentee;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import abhilash.example.com.melonicious.R;

public class ViewMenteeFragment extends Fragment {

    private ViewMenteeViewModel mViewModel;

    public static ViewMenteeFragment newInstance() {
        return new ViewMenteeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_mentee_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewMenteeViewModel.class);
        // TODO: Use the ViewModel
    }

}
