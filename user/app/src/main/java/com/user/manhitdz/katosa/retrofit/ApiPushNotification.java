package com.user.manhitdz.katosa.retrofit;

import com.user.manhitdz.katosa.model.NotiResponse;
import com.user.manhitdz.katosa.model.NotiSendData;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiPushNotification {
    @Headers(
            {
                    "Content-Type: application/json",
                    "Authorization: key=AAAAimkRFbU:APA91bFx2P78q_voJ2kSHhN2nl_gTgEmJUmHjEyWapd7KeSGTq2F5afihl1cEZCOosIlJR_0bqT9JqDvA5VJ7_eBe880XtXLYyR3jowdl0TXK-K0fLSosJV_M7H3rkpigtLkB2WikyI5"

            }
    )
    @POST("fcm/send")
    Observable<NotiResponse> sendNofitication(@Body NotiSendData data);
}
