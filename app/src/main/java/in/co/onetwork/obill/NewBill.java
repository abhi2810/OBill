package in.co.onetwork.obill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class NewBill extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    TextView tax,discount,tamt;
    String name,add,mob,amount,taxp,discp;
    FirebaseAuth mAuth;
    int up=0;//to check if update was pressed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth=FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bill);
        ed1=(EditText)findViewById(R.id.cname);
        ed2=(EditText)findViewById(R.id.cadd);
        ed3=(EditText)findViewById(R.id.mob);
        ed4=(EditText)findViewById(R.id.amount);
        ed5=(EditText)findViewById(R.id.taxp);
        ed6=(EditText)findViewById(R.id.discp);
        tax=(TextView)findViewById(R.id.tax);
        discount=(TextView)findViewById(R.id.disc);
        tamt=(TextView)findViewById(R.id.tamt);
    }
    public void gbill(View v){
        name=ed1.getText().toString();
        add=ed2.getText().toString();
        mob=ed3.getText().toString();
        amount=ed4.getText().toString();
        taxp=ed5.getText().toString();
        discp=ed6.getText().toString();
        if(name.equals("")||add.equals("")||mob.equals("")||amount.equals("")||taxp.equals("")||discp.equals("")){
            Toast.makeText(this, "Fields empty!", Toast.LENGTH_SHORT).show();
        }else{
            if(up==0){
                Toast.makeText(this, "Please press update button", Toast.LENGTH_SHORT).show();
            }else{

            }
        }
    }
    public void update(View v){
        taxp=ed5.getText().toString();
        discp=ed6.getText().toString();
        amount=ed4.getText().toString();
        if(taxp.equals("")||discp.equals("")){
            Toast.makeText(this, "enter tax percentage and discount percentage", Toast.LENGTH_SHORT).show();
        }else{
            if(amount.equals("")){
                Toast.makeText(this, "Enter amount.", Toast.LENGTH_SHORT).show();
            }else{
                double amt=Double.parseDouble(amount);
                double tp=Double.parseDouble(taxp);
                double dp=Double.parseDouble(discp);
                double t=amt*tp/100;
                double d=amt*dp/100;
                tax.setText(""+t);
                discount.setText(""+d);
                tamt.setText(""+(amt+t-d));
                up++;
            }
        }
    }
}
