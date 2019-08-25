package abhilash.example.com.melonicious.addmentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.adapters.ToolbarBindingAdapter;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.model.Mentee;

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
                viewModel = new AddMenteeViewModel(username.getText().toString());
                observeViewModal();
            }
        });
    }
}
