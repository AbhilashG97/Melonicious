package abhilash.example.com.melonicious.addmentee;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.model.Mentee;
import abhilash.example.com.melonicious.utility.Utility;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddMenteeFragment extends Fragment {

    private AddMenteeViewModel viewModel;
    private EditText username;
    private EditText skillsets;
    private EditText interests;
    private Button addUser;


    public AddMenteeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_mentee, container, false);
        viewModel = ViewModelProviders.of(this).get(AddMenteeViewModel.class);

        username = view.findViewById(R.id.editText_username);
        skillsets = view.findViewById(R.id.editText_skillset);
        interests = view.findViewById(R.id.editText_interests);
        addUser = view.findViewById(R.id.button_add_user);

        onAddUserButtonClicked();

        return view;
    }
    private void observeViewModal() {
        viewModel.getMenteeObservable().observe(this, new Observer<Mentee>() {
            @Override
            public void onChanged(Mentee mentee) {
                Log.i("FETCHED USER", mentee.toString());
                Toast.makeText(getContext(), mentee.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void onAddUserButtonClicked() {
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setMenteeLiveData(username.getText().toString(),
                        Utility.getListFromCSV(interests.getText().toString()),
                        Utility.getListFromCSV(skillsets.getText().toString()));
                observeViewModal();
            }
        });
    }
}
