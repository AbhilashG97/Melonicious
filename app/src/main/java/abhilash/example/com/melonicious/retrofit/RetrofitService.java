package abhilash.example.com.melonicious.retrofit;

import abhilash.example.com.melonicious.model.Mentee;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("/users/{user}")
    Observable<Mentee> getMentee(@Path("user") String username);

}
