package org.gdg_lome.codelab_listview_customadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * programme scolaire : liste des matieres :)
 */

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ArrayList<HashMap<String, String>> programmes =
            new ArrayList<HashMap<String, String>>();
    private String [] keys = {"logo","nom","description"};
    public static String [][] data = {
            {String.valueOf(R.mipmap.ic_launcher),"Maths","Description des maths"},
            {String.valueOf(R.mipmap.ic_launcher),"Algorithme","Description algorithme"},
            {String.valueOf(R.mipmap.ic_launcher),"Electronique","Description electronique"},
            {String.valueOf(R.mipmap.ic_launcher),"Anglais","Description anglais"}
    };

    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.list);

        for (int i=0;i<data.length;i++){
            HashMap<String,String> programme = new HashMap<String,String>();
            for(int j=0;j<keys.length;j++){
                programme.put(keys[j],data[i][j]);
            }
            programmes.add(programme);
        }

        adapter = new ListAdapter(this,programmes);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,programmes.get(position).get("nom"),Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
