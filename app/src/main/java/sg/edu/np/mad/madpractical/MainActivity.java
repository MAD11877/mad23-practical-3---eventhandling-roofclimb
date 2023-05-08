package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    User user;

    final String TAG="Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=new User("John","hello", 1234,true);


    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG,"on start!!");
        Intent myRecvIntent = getIntent();
        int recvUserId;
        recvUserId=myRecvIntent.getIntExtra("UserId",0);
        Log.v(TAG,"Userid"+recvUserId);
        TextView profile=findViewById(R.id.textView);
        profile.setText("MAD "+recvUserId);


        Button buttonA = findViewById(R.id.button1);
        buttonA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.v(TAG,"Button A clicked");
                if(user.followed)
                {
                    buttonA.setText("UnFollow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                    user.followed=false;
                }else{
                    buttonA.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                    user.followed=true;
                }
            }

        });

    }
}