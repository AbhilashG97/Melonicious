package abhilash.example.com.melonicious.viewmentee;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.model.Mentee;
import de.hdodenhof.circleimageview.CircleImageView;

public class ViewMenteeRecyclerViewAdapter extends RecyclerView.Adapter<ViewMenteeRecyclerViewAdapter.ViewMenteeViewHolder> {

    private List<Mentee> menteeList;

    public ViewMenteeRecyclerViewAdapter(List<Mentee> menteeList) {
        this.menteeList = menteeList;
    }

    @NonNull
    @Override
    public ViewMenteeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_mentee,
                parent, false);

        return new ViewMenteeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewMenteeViewHolder holder, int position) {
        Log.i("ADAPTER INFO", menteeList.get(position).getLogin()+"");
        Log.i("ADAPTER INFO", Uri.parse(menteeList.get(position).getAvatarUrl())+"");
        holder.menteeUsername.setText(menteeList.get(position).getLogin());
        Picasso.get().load(menteeList.get(position).getAvatarUrl()).into(holder.menteeCircleImageView);
    }

    @Override
    public int getItemCount() {
        return menteeList.size();
    }

    public static class ViewMenteeViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView menteeCircleImageView;
        public TextView menteeUsername;

        public ViewMenteeViewHolder(@NonNull View itemView) {
            super(itemView);
            menteeCircleImageView = itemView.findViewById(R.id.image_mentee_profile);
            menteeUsername = itemView.findViewById(R.id.text_mentee_username);
        }
    }
}
