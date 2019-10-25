package abhilash.example.com.melonicious.viewmenteerepositories;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import abhilash.example.com.melonicious.model.Repository;

/**
 * A singleton which fetches repositories of a given Mentee.
 */
public class ViewMenteeRepositoriesRepository {

    private static ViewMenteeRepositoriesRepository viewMenteeRepositoriesRepository;

    private List<Repository> repositoryArrayList;
    private Context context;

    public static ViewMenteeRepositoriesRepository getInstance(Context context) {
        if (viewMenteeRepositoriesRepository == null) {
            viewMenteeRepositoriesRepository = new ViewMenteeRepositoriesRepository(context);
        }
        return viewMenteeRepositoriesRepository;
    }

    private ViewMenteeRepositoriesRepository(Context context) {
        this.context = context;
        // TODO: Initialize Repository database
    }

    public List<Repository> getRepositories() {
        List<Repository> repositories = new ArrayList<>();
        return repositories;
    }
}
