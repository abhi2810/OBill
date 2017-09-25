package in.co.onetwork.obill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }
    public void newb(View v){
        startActivity(new Intent(this,NewBill.class));
    }
    public void all(View v){
        startActivity(new Intent(this,AllBill.class));
    }
}
