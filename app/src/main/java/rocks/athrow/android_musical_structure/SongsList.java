package rocks.athrow.android_musical_structure;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsList extends AppCompatActivity {
    ListView songList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        // Create 50 dummy songs to populate the list view
        String songName = getResources().getString(R.string.song_name_placeholder);
        String songAuthor = getResources().getString(R.string.song_author_placeholder);
        int songsCount = 50;
        int i = 0;
        ArrayList<String[]> songsList = new ArrayList<>();
        while( i < songsCount){
            String[] song = new String[]{ songName, songAuthor};
            songsList.add(i, song);
            i++;
        }
        // Set an adapter on the list view
        songList = (ListView) findViewById(R.id.songs_list);
        songList.setAdapter(new SongsAdapter(this, songsList ));
        // Set an on click listener on the add_song fab button
        FloatingActionButton addSongsFab = (FloatingActionButton) findViewById(R.id.add_songs);
        addSongsFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addSongs = new Intent(getApplicationContext(), AddSongs.class);
                startActivity(addSongs);
            }
        });

    }
}
