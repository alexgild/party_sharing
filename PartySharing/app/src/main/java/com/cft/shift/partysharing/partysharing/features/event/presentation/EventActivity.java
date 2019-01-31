package com.cft.shift.partysharing.partysharing.features.event.presentation;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cft.shift.partysharing.partysharing.MembersFragment;
import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;

public class EventActivity extends AppCompatActivity {
    private TextView event_name;
    private TextView event_description;
    private TextView event_date;
    private TextView event_location;
    private TextView event_creator_name;
    private TextView event_members_num;
    private Button event_members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_event);
        configureView();
    }
    private void configureView(){
        event_name = findViewById(R.id.title_event_name);
        event_creator_name = findViewById(R.id.events_autor);
        event_date = findViewById(R.id.event_date);
        event_description= findViewById(R.id.event_description);
        event_location=findViewById(R.id.event_location);
        event_members_num=findViewById(R.id.event_members_num);
        event_members=findViewById(R.id.event_members);
        event_members.setOnClickListener(onMembersButtonClicjListener);
    }

    private View.OnClickListener onMembersButtonClicjListener = new View.OnClickListener() {
        Fragment fragment = null;
        @Override
        public void onClick(View v) {
            fragment = new MembersFragment();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.event_frame ,fragment);
            ft.commit();


        }

    };

}