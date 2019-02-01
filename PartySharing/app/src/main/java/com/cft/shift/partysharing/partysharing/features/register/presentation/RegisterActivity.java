package com.cft.shift.partysharing.partysharing.features.register.presentation;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedActivity;
import com.cft.shift.partysharing.partysharing.util.IdSaver;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterAdapter registerAdapter;
    private ViewPager registerPager;
    private SpringDotsIndicator indicator;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (IdSaver.getId(this) != 0) {
            Intent myIntent = new Intent(this, FeedActivity.class);
            this.startActivity(myIntent);
        }
        presenter = RegisterPresenterFactory.createPresenter(this);
        presenter.attachView(this);
        setContentView(R.layout.activity_register);
        registerPager = findViewById(R.id.register_pager);
        indicator = findViewById(R.id.spring_dots_indicator);
        registerAdapter = new RegisterAdapter(getSupportFragmentManager());
        registerPager.setAdapter(registerAdapter);
        indicator.setViewPager(registerPager);
    }

    @Override
    public void onBackPressed() {
        if (registerPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            registerPager.setCurrentItem(registerPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void showError(String error) {
        ProfileRegisterFragment fragment = (ProfileRegisterFragment) registerAdapter.getItem(1);
        fragment.showError(error);
    }

    private class RegisterAdapter extends FragmentStatePagerAdapter {

        public RegisterAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i == 0) {
                return new InterestRegisterFragment();
            }
            if (i == 1) {
                return new ProfileRegisterFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }

    public RegisterPresenter getPresenter() {
        return presenter;
    }
}
