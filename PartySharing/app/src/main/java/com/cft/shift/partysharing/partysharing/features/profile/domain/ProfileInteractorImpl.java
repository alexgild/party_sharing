package com.cft.shift.partysharing.partysharing.features.profile.domain;

import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileDataSource;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

// Обащаемся к API модели Profile
public class ProfileInteractorImpl implements ProfileInteractor{
    private final ProfileDataSource profileBase;
    public ProfileInteractorImpl(ProfileDataSource profileBase){
        this.profileBase = profileBase;
    }

    @Override
    public void loadProfile(Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest) {
        profileBase.getProfile(carry,getProfileRequest);
    }

    @Override
    public void loadEvents(Carry<GetAllEventsResponse> carry) {
        profileBase.getEvents(carry);
    }
}
