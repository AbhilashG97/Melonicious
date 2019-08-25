package abhilash.example.com.melonicious.retrofit;

import abhilash.example.com.melonicious.model.Mentee;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("/users/{user}")
    Call<Mentee> getMentee(@Path("user") String username);

}
