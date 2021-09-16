package com.masai.fragmentassignment1a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final  String TAG =MainActivity.class.getSimpleName();
    private Button mAddA;
    private Button mAddB;
    private Button mReplaceBwithA;
    private Button mRemoveA;
    private Button mRemoveB;
    private Button mReplaceAWithBwithBAckStack;
    private Button mReplaceAWithBWithoutBackStack;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initView();
    }

    private void initView() {
        mAddA = findViewById(R.id.btnAddA);
        mAddB =findViewById(R.id.btnAddB);
        mRemoveA=findViewById(R.id.btnRemoveA);
        mRemoveB=findViewById(R.id.btnRemoveB);
        mReplaceBwithA=findViewById(R.id.btnReplaceBWithA);
        mReplaceAWithBwithBAckStack= findViewById(R.id.btnReplaceAWithBackStack);
        mReplaceAWithBWithoutBackStack=findViewById(R.id.btnReplaceAWithBWithoutBackstack);

        mAddA.setOnClickListener(this);
        mAddB.setOnClickListener(this);
        mRemoveA.setOnClickListener(this);
        mRemoveB.setOnClickListener(this);
        mReplaceAWithBWithoutBackStack.setOnClickListener(this);
        mReplaceAWithBwithBAckStack.setOnClickListener(this);
        mReplaceBwithA.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnAddA:
                addA();
                break;
                
            case R.id.btnAddB:
                addB();
                break;
                
            case R.id.btnReplaceAWithBackStack:
                replaceAWithBackStack();
                break;
                
            case R.id.btnRemoveA:
                removeA();
                break;
                
            case R.id.btnRemoveB:
                removeB();
                break;
                
            case R.id.btnReplaceAWithBWithoutBackstack:
                ReplaceAWithBWithoutBackStack();
                break;
                
            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;
        }
        
    }

    private void replaceBWithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer,fragmentA,"frag A").commit();
    }

    private void ReplaceAWithBWithoutBackStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB =new FragmentB();
        fragmentTransaction.replace(R.id.flContainer,fragmentB,"fragB").commit();

    }

    private void replaceAWithBackStack() {
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        FragmentB fragmentB =new FragmentB();
        fragmentTransaction.replace(R.id.flContainer,fragmentB,"fragB").addToBackStack("fragB").commit();

    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if(fragmentA!=null) {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.remove(fragmentA).commit();
        }

    }

    private void addA() {
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer,fragmentA,"frag A").commit();


    }
    private void addB() {
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer,fragmentB,"frag B").commit();

    }

    private  void removeB(){
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");

        if(fragmentB!=null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.remove(fragmentB).commit();
        }


    }
    @Override
    public void onStart() {
        super.onStart();
        printLogs("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        printLogs("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        printLogs("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        printLogs("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printLogs("onDestroy");
    }

    private void printLogs(String message) {
        Log.d(TAG, message);
    }
}
