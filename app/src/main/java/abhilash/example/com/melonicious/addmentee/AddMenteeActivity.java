package abhilash.example.com.melonicious.addmentee;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.model.Mentee;
import abhilash.example.com.melonicious.utility.Utility;

public class AddMenteeActivity extends AppCompatActivity {

    private AddMenteeViewModel viewModel;
    private EditText username;
    private EditText skillsets;
    private EditText interests;
    private Button addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentee);
        viewModel = ViewModelProviders.of(this).get(AddMenteeViewModel.class);

        username = findViewById(R.id.editText_username);
        skillsets = findViewById(R.id.editText_skillset);
        interests = findViewById(R.id.editText_interests);
        addUser = findViewById(R.id.button_add_user);

        onAddUserButtonClicked();
    }

    private void observeViewModal() {
        viewModel.getMenteeObservable().observe(this, new Observer<Mentee>() {
            @Override
            public void onChanged(Mentee mentee) {
                Log.i("FETCHED USER", mentee.toString());
                Toast.makeText(getBaseContext(), mentee.toString(), Toast.LENGTH_LONG).show();
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
                finish();
            }
        });
    }
}
