package net.mcalamelli.lifelogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.Path;

//public interface Lifelog(String content, String date, String time) {
//    this.content = content;
//    this.date = date;
//}

//https://www.mcalamelli.net/wp-json/wp/v2/lifelogs
//public interface LifelogsService {
//    @GET("users/{user}/repos")
//    Call<List<Lifelog>> listRepos(@Path("user") String user);
//}

public class LifelogsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifelogslist);
    }
}
