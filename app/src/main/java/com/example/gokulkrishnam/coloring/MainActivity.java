package com.example.gokulkrishnam.coloring;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout l;
    TextView t1,t2,t3;
    int Red,B,G;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=(RelativeLayout)findViewById(R.id.rel);

        SharedPreferences getback=getSharedPreferences("MyData",Context.MODE_PRIVATE);
        Red=getback.getInt("Red",0);
        G=getback.getInt("G",0);
        B=getback.getInt("B",0);

        l.setBackgroundColor(Color.rgb(Red,G,B));

        t1=(TextView)findViewById(R.id.textView);
        t1.setBackgroundColor(Color.WHITE);
        t1.setText("Red Color Value:"+Red);

        t2=(TextView)findViewById(R.id.textView4);
        t2.setBackgroundColor(Color.WHITE);
        t2.setText("Red Color Value:"+G);

        t3=(TextView)findViewById(R.id.textView5);
        t3.setBackgroundColor(Color.WHITE);
        t3.setText("Red Color Value:"+B);


    }

    @Override
    protected void onDestroy() {
        SharedPreferences save = getSharedPreferences("MyData",Context.MODE_PRIVATE);
        SharedPreferences.Editor eee= save.edit();
        eee.putInt("Red",Red);
        Log.d("vivz", "onDestroy: "+save.getInt("Red",0));
        eee.putInt("G",G);
        eee.putInt("B",B);
        eee.commit();
        super.onDestroy();
    }

    void color (View v)
    {

        l=(RelativeLayout)findViewById(R.id.rel);

        t1=(TextView)findViewById(R.id.textView);
        t1.setBackgroundColor(Color.WHITE);

        t2=(TextView)findViewById(R.id.textView4);
        t2.setBackgroundColor(Color.WHITE);

        t3=(TextView)findViewById(R.id.textView5);
        t3.setBackgroundColor(Color.WHITE);

        if(v.getId()==R.id.button)
         {
            Red=Red+9;
            if(Red>255)
                Red=0;
            t1.setText("Red Color Value:"+Red);

            l.setBackgroundColor(Color.rgb(Red,G,B));
         }
        else if(v.getId()==R.id.button2)
        {
            G=G+9;
            if(G>255)
                G=0;
            t2.setText("Green Color Value:"+G);
            l.setBackgroundColor(Color.rgb(Red,G,B));
        }
        else if(v.getId()==R.id.button3)
        {
            B=B+9;
            if(B>255)
                B=0;
            t3.setText("Blue Color Value:"+B);
            l.setBackgroundColor(Color.rgb(Red,G,B));
        }

    }

    public void reset(View v)
    {
        Red=0;
        B=0;
        G=0;
        l=(RelativeLayout)findViewById(R.id.rel);
        l.setBackgroundColor(Color.rgb(Red,G,B));

        SharedPreferences save = getSharedPreferences("MyData",Context.MODE_PRIVATE);
        SharedPreferences.Editor eee= save.edit();
        eee.putInt("Red",0);
        eee.putInt("G",0);
        eee.putInt("B",0);
        eee.commit();

        t1=(TextView)findViewById(R.id.textView);
        t1.setBackgroundColor(Color.WHITE);
        t1.setText("Red Color Value:"+Red);

        t2=(TextView)findViewById(R.id.textView4);
        t2.setBackgroundColor(Color.WHITE);
        t2.setText("Red Color Value:"+G);

        t3=(TextView)findViewById(R.id.textView5);
        t3.setBackgroundColor(Color.WHITE);
        t3.setText("Red Color Value:"+B);


    }


}
