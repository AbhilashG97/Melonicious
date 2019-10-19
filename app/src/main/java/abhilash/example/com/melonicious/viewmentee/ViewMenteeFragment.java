package abhilash.example.com.melonicious.viewmentee;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.addmentee.AddMenteeFragment;
import abhilash.example.com.melonicious.customlistener.ClickListener;

public class ViewMenteeFragment extends Fragment {

    private ViewMenteeViewModel mViewModel;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private ViewMenteeRecyclerViewAdapter viewMenteeRecyclerViewAdapter;

    public static ViewMenteeFragment newInstance() {
        return new ViewMenteeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_mentee_fragment, container, false);

        mViewModel = ViewModelProviders.of(this).get(ViewMenteeViewModel.class);

        fab = view.findViewById(R.id.fab_view_mentee);

        onFABClicked();

        recyclerView = view.findViewById(R.id.recycler_view_mentees);

        Log.i("MENTEE LIST FRAG", mViewModel.getMenteeList().toString());

        viewMenteeRecyclerViewAdapter
                = new ViewMenteeRecyclerViewAdapter(mViewModel.getMenteeList());
        recyclerView.setAdapter(viewMenteeRecyclerViewAdapter);
        onRecyclerViewItemClicked();

        return view;
    }

    private void onFABClicked() {
        fab.setOnClickListener(view -> {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.framelayout_content, new AddMenteeFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    private void onRecyclerViewItemClicked() {
        viewMenteeRecyclerViewAdapter.setClickListener(new ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO : Show repositories of the selected user
                Log.i("ITEM CLICKED", "ITEM CLICKED");
            }

            @Override
            public void onLongItemClick(View view, int position) {
                // TODO: Do something interesting here
                Log.i("LONG ITEM CLICK", "LONG PRESS");
            }
        });
    }
}
