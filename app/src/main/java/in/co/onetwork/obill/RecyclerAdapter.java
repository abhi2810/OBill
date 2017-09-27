package in.co.onetwork.obill;
/**
 * Created by abhi on 25/9/17.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHoder>{

    List<Bill> list;
    Context context;

    public RecyclerAdapter(List<Bill> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card,parent,false);
        MyHoder myHoder = new MyHoder(view);


        return myHoder;
    }

    @Override
    public void onBindViewHolder(MyHoder holder, int position) {
        final Bill mylist = list.get(position);
        holder.cname.setText(mylist.getName());
        holder.cadd.setText(mylist.getAdd());
        holder.cmob.setText(mylist.getMob());
        holder.date.setText(mylist.getDate());
        holder.amt.setText(mylist.getAmount());
        holder.disc.setText(mylist.getDisc());
        holder.tax.setText(mylist.getTax());
    }

    @Override
    public int getItemCount() {

        int arr = 0;

        try{
            if(list.size()==0){

                arr = 0;

            }
            else{

                arr=list.size();
            }



        }catch (Exception e){



        }

        return arr;

    }

    class MyHoder extends RecyclerView.ViewHolder{
        TextView cname,cadd,cmob,amt,tax,disc,date;


        public MyHoder(View itemView) {
            super(itemView);
            cname = (TextView) itemView.findViewById(R.id.cname);
            cadd=(TextView)itemView.findViewById(R.id.cadd);
            cmob=(TextView)itemView.findViewById(R.id.cmob);
            date=(TextView)itemView.findViewById(R.id.textView3);
            amt=(TextView)itemView.findViewById(R.id.textView4);
            tax=(TextView)itemView.findViewById(R.id.textView5);
            disc=(TextView)itemView.findViewById(R.id.textView7);
        }
    }

}