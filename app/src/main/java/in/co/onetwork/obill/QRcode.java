package in.co.onetwork.obill;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import net.glxn.qrgen.android.QRCode;

import static android.R.attr.width;
import static android.R.color.black;
import static android.R.color.white;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class QRcode extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        String uid=getIntent().getStringExtra("uid");
        String bid=getIntent().getStringExtra("bid");
        String s=uid+":"+bid;
        Bitmap myBitmap= QRCode.from(s).bitmap();
        img=(ImageView)findViewById(R.id.img);
        img.setImageBitmap(myBitmap);
    }
    public void ok(View v){
        finish();
    }
}
