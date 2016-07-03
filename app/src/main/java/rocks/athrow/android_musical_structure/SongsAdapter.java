package rocks.athrow.android_musical_structure;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by josel on 7/3/2016.
 */
class SongsAdapter extends BaseAdapter {

    Context context;
    ArrayList<String[]> data;
    private static LayoutInflater inflater = null;

    public SongsAdapter(Context context, ArrayList<String[]> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View songItemLayout = convertView;
        if (songItemLayout == null)
            songItemLayout = inflater.inflate(R.layout.song_item, null);
        // Set the data on the views
        TextView songTitle = (TextView) songItemLayout.findViewById(R.id.song_title);
        TextView songAuthor = (TextView) songItemLayout.findViewById(R.id.song_author);
        songTitle.setText(data.get(position)[0]);
        songAuthor.setText(data.get(position)[1]);
        // Set an onClickListener on the song items to open the song details
        LinearLayout songItem = (LinearLayout) songItemLayout.findViewById(R.id.song_item);
        songItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songDetails = new Intent(context, SongDetails.class);
                context.startActivity(songDetails);
            }
        });
        return songItemLayout;
    }
}