package abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.achievements;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.model.Achievement;

public class AchievementsRecyclerViewAdapter extends
        RecyclerView.Adapter<AchievementsRecyclerViewAdapter.AchievementsViewHolder> {

    private ArrayList<Achievement> achievementArrayList;

    public AchievementsRecyclerViewAdapter(ArrayList<Achievement> achievementArrayList) {
        Log.i("ACHIEVEMENT", achievementArrayList.toString());
        this.achievementArrayList = achievementArrayList;
    }

    @NonNull
    @Override
    public AchievementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AchievementsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_achievement, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementsViewHolder holder, int position) {
        holder.achievementLogo.setImageResource(achievementArrayList.get(position).getImageId());
        holder.achievementTitle.setText(achievementArrayList.get(position).getAchievementName());
    }

    @Override
    public int getItemCount() {
        return achievementArrayList.size();
    }

    static class AchievementsViewHolder extends RecyclerView.ViewHolder {

        private ImageView achievementLogo;
        private TextView achievementTitle;

        AchievementsViewHolder(@NonNull View itemView) {
            super(itemView);
            achievementLogo = itemView.findViewById(R.id.image_achievement_logo);
            achievementTitle = itemView.findViewById(R.id.text_achievement_title);
        }
    }
}
