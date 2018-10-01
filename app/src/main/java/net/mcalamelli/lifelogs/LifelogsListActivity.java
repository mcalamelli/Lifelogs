package net.mcalamelli.lifelogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.http.GET;
import retrofit2.http.Path;

//public interface LifelogsService {
//    @GET("users/{user}/repos")
//    Call<List<Repo>> listRepos(@Path("user") String user);
//}

public class LifelogsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifelogslist);
    }
}
