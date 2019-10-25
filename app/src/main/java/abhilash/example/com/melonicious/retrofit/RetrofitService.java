package abhilash.example.com.melonicious.retrofit;

import java.util.List;

import abhilash.example.com.melonicious.model.Mentee;
import abhilash.example.com.melonicious.model.Repository;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("/users/{user}")
    Observable<Mentee> getMentee(@Path("user") String username);

    @GET("/users/{user}/repos")
    Observable<List<Repository>> getRepositories(@Path("user") String username);

}
