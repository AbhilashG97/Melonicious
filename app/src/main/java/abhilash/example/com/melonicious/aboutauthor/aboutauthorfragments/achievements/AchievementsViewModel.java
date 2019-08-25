package abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.achievements;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.model.Achievement;

public class AchievementsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Achievement>> achievementArrayListMutableLiveData;

    public AchievementsViewModel() {
        achievementArrayListMutableLiveData = new MutableLiveData<>();
        achievementArrayListMutableLiveData.setValue(getAchievements());
    }

    private ArrayList<Achievement> getAchievements() {
        ArrayList<Achievement> achievementList = new ArrayList<>();
        achievementList.add(new Achievement("Google Summer of Code Mentor 2019", R.drawable.gsoc));
        achievementList.add(new Achievement("Google Code-In Mentor 2017", R.drawable.gci));
        achievementList.add(new Achievement("Google Code-In Mentor 2018", R.drawable.gci));
        achievementList.add(new Achievement("GirlScript Summer of Code Mentor", R.drawable.gssoc));
        achievementList.add(new Achievement("Kharagpur Winter of Code Mentor", R.drawable.kwoc));

        return achievementList;
    }

    public MutableLiveData<ArrayList<Achievement>> getAchievementArrayListMutableLiveData() {
        return achievementArrayListMutableLiveData;
    }

}
