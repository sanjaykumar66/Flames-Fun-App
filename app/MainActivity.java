package com.example.hp.mypp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    Button f;
    EditText d,d1,d2;
    int n,n1,z,q;
    StringBuffer s,s1;
    RelativeLayout rl;
    Animation  animBlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f = (Button) findViewById(R.id.button);
        d = (EditText) findViewById(R.id.editText);
        d1 = (EditText) findViewById(R.id.editText2);
        d2 = (EditText) findViewById(R.id.editText3);
        rl =(RelativeLayout) findViewById(R.id.layout);
        f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                String sq= String.valueOf(d.getText());
                String sq1= String.valueOf(d1.getText());
                sq=sq.toLowerCase();
                sq1=sq1.toLowerCase();
                sq= sq.replaceAll("\\s","");
                sq1= sq1.replaceAll("\\s","");
                s = new StringBuffer(sq);
                s1 = new StringBuffer(sq1);
                n = s.length();
                n1 = s1.length();
                z = n + n1;
                boolean check=validate(sq,sq1);
                if(check)
                {
                    for (int i = 0; i < n; i++) {
                        char c = s.charAt(i);
                        for (int j = 0; j < n1; j++) {
                            char d = s1.charAt(j);
                            if (c == d) {
                                s.deleteCharAt(i);
                                s1.deleteCharAt(j);
                                n = s.length();
                                n1 = s1.length();
                                z = z - 2;
                                i = 0;
                                j = 0;
                            }
                        }
                    }
                    int n2 = n + n1;
                    String mid="flames";
                    char[] s2=mid.toCharArray();
                    int str_len=6;
                    int i=1,j=0;
                    while(str_len>1) {
                        if (n2 == i) {
                            for (int k = j; k < str_len - 1; k++) {
                                s2[k] = s2[k + 1];
                            }
                            s2[str_len - 1] = '\0';
                            str_len = str_len - 1;
                            i = 0;
                            j = j - 1;
                        }
                        j++;
                        if (j == str_len) {
                            j = 0;
                        }
                        i++;
                    }
                    char result=s2[0];
                    switch (result) {
                        case 'f': {
                            animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                                    R.anim.blink);
                            d2.setText(sq1 + " is ur Friend");
                            d2.setVisibility(View.VISIBLE);
                            d2.startAnimation(animBlink);
                        }
                        break;
                        case 'l':
                        {   animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.blink);
                            d2.setText(sq1 + " is ur Love");
                            d2.setVisibility(View.VISIBLE);
                            d2.startAnimation(animBlink);
                        }
                        break;
                        case 'a':
                        {   animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.blink);
                            d2.setText(sq1 + " is ur Affection");
                            d2.setVisibility(View.VISIBLE);
                            d2.startAnimation(animBlink);
                        }
                        break;
                        case 'm':
                        {
                            animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                                    R.anim.blink);
                            d2.setText("u r going to marry " + sq1);
                            d2.setVisibility(View.VISIBLE);
                            d2.startAnimation(animBlink);
                        }
                        break;
                        case 'e':
                        {
                            animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                                    R.anim.blink);
                            d2.setText(sq1 + " is ur Enemy");
                            d2.setVisibility(View.VISIBLE);
                            d2.startAnimation(animBlink);
                        }
                        break;
                        case 's':
                        {
                            animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                                    R.anim.blink);
                            d2.setText(sq1 + " is ur Sister");
                            d2.setVisibility(View.VISIBLE);
                            d2.startAnimation(animBlink);
                        }
                        break;
                    }
                }

                //d2.setText("result");
            }
        });
    }
    public boolean validate(String s1, String s2)
    {
        int flag=0;
        if(s1.isEmpty())
        {
            d.setError("Field Cannot be Empty");
            flag=1;

        }
        if(s2.isEmpty())
        {
            d1.setError("Field cannot be Empty");
            flag=1;
        }
        if(!s1.matches("[a-zA-Z ]+"))
        {
            d.setError("Field Can contain only characters");
            flag=1;
        }
        if(!s2.matches("[a-zA-Z ]+"))
        {
            d1.setError("Field Can contain only characters");
            flag=1;
        }
        if(flag==1)
        {
            d2.setText("");
            d2.setHint(" Both are in");
            return false;

        }
        else
            return true;
    }
}