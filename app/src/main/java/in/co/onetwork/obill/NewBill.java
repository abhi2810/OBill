package in.co.onetwork.obill;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class NewBill extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    TextView tax,discount,tamt;
    String name,add,mob,amount,taxp,discp;
    FirebaseAuth mAuth;
    DatabaseReference merchant= FirebaseDatabase.getInstance().getReference().child("merchants");
    DatabaseReference me;
    int up=0;//to check if update was pressed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth=FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bill);
        if(mAuth.getCurrentUser()!=null){
            String uid=mAuth.getCurrentUser().getUid();
            me=merchant.child(uid).child("bills").getRef();
        }else{
            startActivity(new Intent(this,Login.class));
        }
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
    @RequiresApi(api = Build.VERSION_CODES.N)
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
                final String key=me.push().getKey();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String date = sdf.format(new Date());
                Bill b=new Bill(name,add,mob,tax.getText().toString(),discount.getText().toString(),tamt.getText().toString(),date,key);
                me.child(key).setValue(b).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(NewBill.this, "Bill generated!!", Toast.LENGTH_SHORT).show();
                            reset();
                            Intent i=new Intent(NewBill.this,QRcode.class);
                            i.putExtra("uid",mAuth.getCurrentUser().getUid());
                            i.putExtra("bid",key);
                            startActivity(i);
                        }else{
                            Toast.makeText(NewBill.this, "Error contact developers!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
    public void reset(){
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        ed6.setText("");
        up=0;
        tax.setText("");
        discount.setText("");
        tamt.setText("");
    }
}
