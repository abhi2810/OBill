package in.co.onetwork.obill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllBill extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<Bill> list;
    RecyclerView recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_bill);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("merchants").child(mAuth.getCurrentUser().getUid()).child("bills").getRef();
        list=new ArrayList<Bill>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Bill bill=dataSnapshot1.getValue(Bill.class);
                    Bill b=new Bill(bill.getName(),bill.getAdd(),bill.getMob(),bill.getTax(),bill.getDisc(),bill.getAmount(),bill.getDate(),bill.getBid());
                    list.add(b);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void refresh(View v){
        if(list.isEmpty())
            Toast.makeText(this, "No element found", Toast.LENGTH_SHORT).show();
        else {
            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, AllBill.this);
            RecyclerView.LayoutManager recyce = new LinearLayoutManager(AllBill.this);
            recycle.setLayoutManager(recyce);
            recycle.setItemAnimator(new DefaultItemAnimator());
            recycle.setAdapter(recyclerAdapter);
        }
    }
}
