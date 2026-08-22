package com.github.kotvertolet.youtubejextractor.network;

import android.util.Log;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: loaded from: classes7.dex */
public class RequestExecutor {
    private String TAG = "RequestExecutor";
    private int attemptsCounter = 0;
    private Response<ResponseBody> response = null;

    public Response<ResponseBody> executeWithRetry(Call<ResponseBody> call) throws YoutubeRequestException {
        try {
            this.response = call.execute();
        } catch (IOException e2) {
            if (this.attemptsCounter < 2) {
                Log.i(this.TAG, "Attempting to receive successful response, attempt #" + this.attemptsCounter);
                this.attemptsCounter++;
                executeWithRetry(call.clone());
            } else {
                throw new YoutubeRequestException(String.format("Could not receive successfulresponse after 3 attempts, check the internet connection, http code was: '%s'", Integer.valueOf(this.response.code())), e2);
            }
        }
        return this.response;
    }
}
