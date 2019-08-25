package abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.skillset;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import abhilash.example.com.melonicious.R;

public class SkillSetRecyclerViewAdapter extends
        RecyclerView.Adapter<SkillSetRecyclerViewAdapter.SkillSetViewHolder> {

    private ArrayList<String> skillSetList;

    public SkillSetRecyclerViewAdapter(ArrayList<String> skillSetList) {
        this.skillSetList = skillSetList;
    }

    @NonNull
    @Override
    public SkillSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SkillSetViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_skillset, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillSetViewHolder holder, int position) {
        holder.skillsetName.setText(skillSetList.get(position));
    }

    @Override
    public int getItemCount() {
        return skillSetList.size();
    }

    public static class SkillSetViewHolder extends RecyclerView.ViewHolder {

        private TextView skillsetName;

        public SkillSetViewHolder(@NonNull View itemView) {
            super(itemView);
            skillsetName = itemView.findViewById(R.id.text_skill_set_item);
        }
    }

}
