package abhilash.example.com.melonicious.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import abhilash.example.com.melonicious.viewmentee.ViewMenteeFragment;

public class ViewMenteeRepositoriesPagerAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public ViewMenteeRepositoriesPagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ViewMenteeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
