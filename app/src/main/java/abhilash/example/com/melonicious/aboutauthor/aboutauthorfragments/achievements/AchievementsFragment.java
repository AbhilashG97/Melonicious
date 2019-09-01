package abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.achievements;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import abhilash.example.com.melonicious.R;

public class AchievementsFragment extends Fragment {

    private AchievementsViewModel mViewModel;
    private RecyclerView recyclerView;

    public AchievementsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(AchievementsViewModel.class);
        View view = inflater.inflate(R.layout.achievements_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_achievements);
        Log.i("ACHIEVEMENTS", mViewModel
                .getAchievementArrayListMutableLiveData().getValue().toString());
        recyclerView.setAdapter(new AchievementsRecyclerViewAdapter(mViewModel
                .getAchievementArrayListMutableLiveData().getValue()));
        return view;
    }

}
