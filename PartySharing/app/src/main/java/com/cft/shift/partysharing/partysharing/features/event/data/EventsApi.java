package com.cft.shift.partysharing.partysharing.features.event.data;

import com.cft.shift.partysharing.partysharing.network.exchange.GetEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface EventsApi {
    @GET("/event")
    Call<GetEventResponse> getEvent(@Body GetEventRequest getEventRequest);

    @GET("/profiles")
    Call<GetProfilesResponse> getProfiles(@Body GetProfilesRequest getProfilesRequest);
}
