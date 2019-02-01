package com.cft.shift.partysharing.partysharing.features.create.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.create.domain.CreateInteractor;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventResponse;
import com.cft.shift.partysharing.partysharing.types.InterestType;

public class CreatePresenter extends MvpPresenter<CreateActivityView>{

    CreateInteractor interactor;

    private AddEventRequest request = new AddEventRequest();

    public CreatePresenter(CreateInteractor interactor) {
        this.interactor = interactor;
    }

    public void setInterest(InterestType interest) {
        request.setCategory(interest);
    }

    public void setEventInfo(String name, String location, String address,
                          String date, String desc) {
        request.setName(name);
        request.setLocation(location);
        request.setAddress(address);
        request.setDate(date);
        request.setDescription(desc);
    }

    public void setImage(String image) {
        request.setImage(image);
    }

    public void create(Long id) {
        interactor.create(id, request, new Carry<AddEventResponse>() {
            @Override
            public void onSuccess(AddEventResponse result) {

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
