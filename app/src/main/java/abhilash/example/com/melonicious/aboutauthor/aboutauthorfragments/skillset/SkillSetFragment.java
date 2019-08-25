package abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.skillset;

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

public class SkillSetFragment extends Fragment {

    private SkillSetViewModel mViewModel;

    public SkillSetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.skill_set_fragment, container, false);
        mViewModel = ViewModelProviders.of(this).get(SkillSetViewModel.class);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_skillset);

        Log.i("SKILLSET", mViewModel
                .getSkillsetArrayListLiveData().getValue().toString());

        recyclerView.setAdapter(new SkillSetRecyclerViewAdapter(mViewModel
                .getSkillsetArrayListLiveData().getValue()));
        return view;
    }

}
