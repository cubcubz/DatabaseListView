package egco.com.databaselistview;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDbHelper;
    ListView myListView;
    SQLiteDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDbHelper = new DatabaseHelper(this);
        mDb = myDbHelper.getWritableDatabase();
        myListView = (ListView) findViewById(R.id.listView1);

        showData();
    }

    public void  showData(){
        Cursor res = myDbHelper.getAllItemInRoom();
        res.moveToFirst();

        if(res.getCount()==0){
           showMessage("no","no data");
            return;
        }

        ArrayList<String> list = new ArrayList<String>();

        while(!res.isAfterLast()){
            list.add(res.getString(1));
            res.moveToNext();
        }



        ArrayAdapter<String>  adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        myListView.setAdapter(adapterDir);
        // here

    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

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
