package abhilash.example.com.melonicious.viewmentee;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.adapters.ViewMenteeRecyclerViewAdapter;

public class ViewMenteeFragment extends Fragment {

    private ViewMenteeViewModel mViewModel;
    private RecyclerView recyclerView;

    public static ViewMenteeFragment newInstance() {
        return new ViewMenteeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_mentee_fragment, container, false);

        mViewModel = ViewModelProviders.of(this).get(ViewMenteeViewModel.class);

        recyclerView = view.findViewById(R.id.recycler_view_mentees);

        Log.i("MENTEE LIST FRAG", mViewModel.getMenteeList().toString());

        ViewMenteeRecyclerViewAdapter viewMenteeRecyclerViewAdapter
                = new ViewMenteeRecyclerViewAdapter(mViewModel.getMenteeList());
        recyclerView.setAdapter(viewMenteeRecyclerViewAdapter);
        return view;
    }

}
