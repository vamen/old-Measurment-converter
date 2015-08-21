package com.example.vivekbalachandran.converter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Units extends ActionBarActivity {

    int[] a=new int[2];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);
        Bundle Extra=getIntent().getExtras();
        a=Extra.getIntArray("EXTRA_VALES");

        final Button go1=(Button)findViewById(R.id.button);
        final Button go2=(Button)findViewById(R.id.button2);
        TextView text1 =(TextView)findViewById(R.id.conv1);
         text1.setText(Dataprovider.getstring1(a[0],a[1]));
        TextView text2 =(TextView)findViewById(R.id.conv2);
        text2.setText(Dataprovider.getstring2(a[0],a[1]));
       final EditText num1=(EditText)findViewById(R.id.editText);
        num1.setHint("0.000");
        num1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT)
                {
                    go1.performClick();
                    return true;
                }
                return false;
            }
        });
       final EditText num2=(EditText)findViewById(R.id.editText2);
          num2.setHint("00.000");
        num2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE)
                {
                    go2.performClick();
                    return true;
                }
                return false;
            }
        });


        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(!num1.getText().toString().matches("")) {
                      double init = Double.parseDouble(num1.getText().toString());
                      init = Dataprovider.convert(init, a[0], a[1], true);
                      num2.setText(String.valueOf(init));
                  }
                else Toast.makeText(Units.this,"PLEASE ENTER A VALUE",Toast.LENGTH_LONG).show();

            }
        });

        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!num2.getText().toString().matches("")) {
                    double init = Double.parseDouble(num2.getText().toString());
                    init = Dataprovider.convert(init, a[0], a[1], false);
                    num1.setText(String.valueOf(init));
                }
                else Toast.makeText(Units.this,"PLEASE ENTER A VALUE",Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_units, menu);
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
            startActivity(new Intent(Units.this,mysetting_activity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
