package com.example.android.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main4Activity extends AppCompatActivity {
    TextView tv3;
     EditText et1;
    Button btn,cb,sb,clb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);
        AlertDialog.Builder builder=new AlertDialog.Builder(Main4Activity.this);
        builder.setMessage("Valid for input till 99,99,99,999");
        builder.setPositiveButton("Ok",null).setCancelable(false);
        AlertDialog alert=builder.create();
        alert.show();
        AdView adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
        et1 = (EditText) findViewById(R.id.et1);
        btn = (Button) findViewById(R.id.bt1);
        tv3=(TextView)findViewById(R.id.tv3);
        cb=(Button)findViewById(R.id.copybtn);
        sb=(Button)findViewById(R.id.shbtn);
        clb=(Button)findViewById(R.id.clrbtn);
        clb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("");
                tv3.setText("");
            }
        });
    }

    public void add(View view)
    {
        String s=et1.getText().toString();
        String s1=remcom(s);
        String st=answer(s1);
        tv3.setText(st.trim());

    }
    public String remcom(String s)
    {
        String str="";
        StringBuffer sb=new StringBuffer(s);
        sb.reverse();
        s=sb.toString();
        for(int i=0;i<s.length();i++)
        {
            if(i==3)
            {
                str=s.charAt(i)+","+str;
            }
            else if(i==5)
            {
                str=s.charAt(i)+","+str;
            }
            else if(i==7)
            {
                str=s.charAt(i)+","+str;
            }
            else
            {
                str=s.charAt(i)+str;
            }
        }
        return str;
    }
    public String check(String s)
    {
        if(s.indexOf("0,")==0)
            return (check(s.substring(s.indexOf(',')+1,s.length())));
        else
            return s;
    }
    public boolean invalid(String a[],int n,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch!=',' && Character.isDigit(ch)==false)
                return false;
        }
        if(n>4)
            return false;
        for(int i=0;i<n;i++)
        {
            if(a[i].equals(""))
                return false;
            if(i==0)
            {
                if(a[i].length()<3)
                {
                    if(n!=1)
                    {
                        return false;
                    }
                }
                else if(a[i].length()>3)
                    return false;
            }
            if(i==1)
            {
                if(a[i].length()<2)
                {
                    if(n!=2)
                        return false;
                }
                else if(a[i].length()>2)
                    return false;
            }
            if(i==2)
            {
                if(a[i].length()<2)
                {
                    if(n!=3)
                        return false;
                }
                else if(a[i].length()>2)
                    return false;
            }
            if(i==3)
            {
                if(a[i].length()>2)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public String answer(String ds)
    {

        String pol="Y";

        int c[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,10000,100000,1000000,10000000,100000000};
        String a[]={"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty","hundred","thousand","thousand","lakh","lakh","crore","crore"};
        for(int i=0;i<a.length;i++)
        {
            a[i]=a[i].toUpperCase();
        }
        String s="",cho="",g="",ds2;
        char chy,chi,cg=' ',cg2=' ';
        String jk[]=new String[10];
        int f=0,h,m1=2,uh=0,uu=0,mk=0;
        boolean v=false,u;
        double m;

        ds=check(ds);
        ds2=ds;
        if(ds.equals("1")==false)
        {
            ds=","+ds;
            for(int i=ds.length()-1;i>=0;i--)
            {
                chy=ds.charAt(i);
                if(chy!=','&&chy!=' ')
                    s=chy+s;
                else
                {
                    jk[uh]=s;
                    s="";
                    uh++;
                }
            }
            u=invalid(jk,uh,ds2);
            if(u==true)
            {
                for(int i=0;i<uh;i++)
                {
                    if(i==0)
                    {
                        for(int j=jk[i].length();j>=1;j--)
                        {
                            chi=jk[i].charAt(j-1);
                            cho+=chi;
                            h=Integer.parseInt(cho);
                            if(j>=2)
                            {
                                if(jk[i].length()==2)
                                {
                                    if(jk[i].charAt(0)!='1')
                                    {
                                        h*=Math.pow(10,f);
                                        uu=h;
                                        for(int k=0;k<=33;k++)
                                        {
                                            if(h==c[k])
                                                g=" "+a[k]+g;
                                        }
                                    }
                                    else
                                    {
                                        h*=Math.pow(10,f);
                                        uu=h;
                                    }
                                }
                                else
                                {
                                    if(jk[i].charAt(1)=='1')
                                    {
                                        if(j==3)
                                        {
                                            for(int k=0;k<=33;k++)
                                            {
                                                if(Integer.parseInt("1"+Integer.toString(h))==c[k])
                                                    g=" "+a[k]+g;
                                            }
                                        }
                                    }
                                    else
                                    {
                                        h*=Math.pow(10,f);
                                        uu=h;
                                        for(int k=0;k<=33;k++)
                                        {
                                            if(h==c[k])
                                                g=" "+a[k]+g;
                                        }
                                    }
                                }
                            }
                            else
                            {
                                if(jk[i].length()<=2)
                                {
                                    if(jk[i].charAt(0)=='1')
                                    {
                                        if(jk[i]=="1")
                                        {
                                            System.out.println("one");
                                        }
                                        else
                                        {
                                            for(int k=0;k<=33;k++)
                                            {
                                                if(Integer.parseInt("1"+Integer.toString(uu))==c[k])
                                                    g=" "+a[k]+g;
                                            }
                                        }
                                    }
                                    else
                                    {
                                        m=Math.pow(10,f);
                                        m1=(int)m*h;
                                        if(h!=0)
                                        {
                                            for(int k=0;k<=33;k++)
                                            {
                                                if(m1==c[k])
                                                    g=" "+a[k]+g;
                                            }
                                        }
                                        else
                                        {
                                            for(int k=0;k<=33;k++)
                                            {
                                                if(h==c[k])
                                                    g=" "+a[k]+g;
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    m=Math.pow(10,f);
                                    m1=(int)m;
                                    if(h!=0)
                                    {
                                        for(int k=0;k<=33;k++)
                                        {
                                            if(m1==c[k])
                                                g=" "+a[k]+g;
                                        }
                                        for(int k=0;k<=33;k++)
                                        {
                                            if(h==c[k])
                                                g=" "+a[k]+g;
                                        }
                                    }
                                    else
                                    {
                                        for(int k=0;k<=33;k++)
                                        {
                                            if(h==c[k])
                                                g=" "+a[k]+g;
                                        }
                                    }
                                }
                            }
                            f++;cho="";
                        }
                        mk=f;
                    }
                    else
                    {
                        switch(i)
                        {
                            case 1:
                                m1=1000;
                                break;
                            case 2:
                                m1=100000;
                                break;
                            case 3:
                                m1=10000000;
                                break;
                        }
                        if(jk[i].length()==2)
                        {
                            cg=jk[i].charAt(0);
                            cg2=jk[i].charAt(1);
                        }
                        else
                        {
                            cg=jk[i].charAt(0);
                            cg2='1';
                        }
                        for(int k=0;k<=33;k++)
                        {
                            if(cg!='0' || cg2!='0')
                            {
                                if(m1==c[k])
                                    g=" "+a[k]+","+g;
                            }
                        }
                        if(jk[i].length()==1)
                        {
                            for(int k=0;k<=33;k++)
                            {
                                if(Integer.parseInt(jk[i])==c[k])
                                {
                                    g=" "+a[k]+g;
                                }
                            }
                        }
                        else
                        {
                            for(int k=0;k<=33;k++)
                            {
                                if(Integer.parseInt(jk[i])==c[k])
                                {
                                    g=" "+a[k]+g;
                                    v=true;
                                }
                            }
                            if(v==false)
                            {
                                int op=Integer.parseInt(jk[i].substring(1,2));
                                for(int k=0;k<=33;k++)
                                {
                                    if(op==c[k])
                                        g=" "+a[k]+g;
                                }
                                int op2=Integer.parseInt(jk[i].substring(0,1))*10;
                                for(int k=0;k<=33;k++)
                                {
                                    if(op2==c[k])
                                        g=" "+a[k]+g;
                                }
                            }
                            v=false;
                        }
                        f++;
                    }
                }
                return(g+" ONLY");
            }
            else
                return("Invalid Number");
        }
        else
        {return("ONE ONLY");}
    }



    }
   // }




