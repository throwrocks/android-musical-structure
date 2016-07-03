package rocks.athrow.android_musical_structure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.songs_list);
        int songsCount = 50;
        int i = 0;
        ArrayList<String[]> songsList = new ArrayList<>();
        while( i < songsCount){
            String[] song = new String[]{"Song Title", "Song Author"};
            songsList.add(i, song);
            i++;
        }

        listview.setAdapter(new SongsAdapter(this, songsList ));


    }
}
