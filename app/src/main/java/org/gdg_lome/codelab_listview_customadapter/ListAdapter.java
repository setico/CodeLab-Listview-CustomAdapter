package org.gdg_lome.codelab_listview_customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by setico on 25/12/2015.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HashMap<String, String>> programmes;

    public ListAdapter(Context context, ArrayList<HashMap<String, String>> programmes) {
        this.context = context;
        this.programmes = programmes;
    }

    public static class ViewHolder{
        public ImageView logo;
        public TextView nom;
        public TextView description;

        public ViewHolder(View view) {
            logo = (ImageView) view.findViewById(R.id.logo);
            nom = (TextView) view.findViewById(R.id.nom);
            description = (TextView) view.findViewById(R.id.description);
        }
    }

    @Override
    public int getCount() {
        return programmes.size();
    }

    @Override
    public Object getItem(int position) {
        return programmes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HashMap<String, String> programme = programmes.get(position);
        ViewHolder viewHolder = null;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.items,null);
            viewHolder = new ViewHolder(convertView);
            viewHolder.logo.setImageDrawable(context.getResources().getDrawable(Integer.valueOf(programme.get("logo"))));
            viewHolder.nom.setText(programme.get("nom"));
            viewHolder.description.setText(programme.get("description"));
        }
        convertView.setTag(viewHolder);
        return convertView;
    }
}
