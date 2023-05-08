package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    String title="Activity List";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(title,"Create!");

        ImageView image = findViewById(R.id.imageView2);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(title,"Image clicked");
                queryProfile();
            }
        });
    }
    private int getRandomNumber(){
        Random ran=new Random();
        int myRandomValue = ran.nextInt(999999);
        return myRandomValue;
    }
    private void queryProfile(){
        int userid=getRandomNumber();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title,"User accepts");
                Log.v(title,"User Id: "+userid);
                Intent myIntent = new Intent(ListActivity.this,MainActivity.class);
                myIntent.putExtra("UserId",userid);
                startActivity(myIntent);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title,"User declines!");
                finish();
            }
        });
        builder.setCancelable(false);

        AlertDialog alert=builder.create();
        alert.show();
    }

}