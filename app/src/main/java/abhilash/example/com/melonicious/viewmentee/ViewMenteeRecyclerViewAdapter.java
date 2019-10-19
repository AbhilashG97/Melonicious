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
import abhilash.example.com.melonicious.customlistener.ClickListener;
import abhilash.example.com.melonicious.model.Mentee;
import de.hdodenhof.circleimageview.CircleImageView;

public class ViewMenteeRecyclerViewAdapter extends RecyclerView.Adapter<ViewMenteeRecyclerViewAdapter.ViewMenteeViewHolder> {

    private List<Mentee> menteeList;
    private ClickListener clickListener;

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

    public class ViewMenteeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public CircleImageView menteeCircleImageView;
        public TextView menteeUsername;

        public ViewMenteeViewHolder(@NonNull View itemView) {
            super(itemView);
            menteeCircleImageView = itemView.findViewById(R.id.image_github_user_profile);
            menteeUsername = itemView.findViewById(R.id.text_mentee_username);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onLongItemClick(view, getAdapterPosition());
            return false;
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
