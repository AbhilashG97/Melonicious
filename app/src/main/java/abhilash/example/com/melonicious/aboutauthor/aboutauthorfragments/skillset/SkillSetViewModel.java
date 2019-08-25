package abhilash.example.com.melonicious.aboutauthor.aboutauthorfragments.skillset;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SkillSetViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> skillArrayListMutableLiveData;

    public SkillSetViewModel() {
        skillArrayListMutableLiveData = new MutableLiveData<>();
        skillArrayListMutableLiveData.setValue(getSkillSet());
    }

    private ArrayList<String> getSkillSet() {
        ArrayList<String> skillSetList = new ArrayList<>();

        skillSetList.add("Android Application Development");
        skillSetList.add("Java Development");
        skillSetList.add("Natural Language Processing");
        skillSetList.add("Python Programming");
        skillSetList.add("Kotlin Programming");
        skillSetList.add("Java EE Development");
        skillSetList.add("Dart Programming");
        skillSetList.add("Internet of Things");
        skillSetList.add("Flutter Development");

        return skillSetList;
    }

    public LiveData<ArrayList<String>> getSkillsetArrayListLiveData() {
        return skillArrayListMutableLiveData;
    }

}
