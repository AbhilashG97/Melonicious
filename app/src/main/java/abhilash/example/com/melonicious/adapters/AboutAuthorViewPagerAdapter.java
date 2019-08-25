package abhilash.example.com.melonicious.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.achievements.AchievementsFragment;
import abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.skillset.SkillSetFragment;

public class AboutAuthorViewPagerAdapter extends FragmentPagerAdapter {
    private int tabCount;

    public AboutAuthorViewPagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new SkillSetFragment();
            case 1:
                return new AchievementsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
