package util;

import android.util.Log;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoggingInterceptor implements Interceptor {
	private static final String TAG = "HTTP Request";

	@Override
	public Response intercept(Interceptor.Chain chain) throws IOException {
		Request request = chain.request();

		long t1 = System.nanoTime();
		Log.d(TAG,String.format("Sending request %s with %s",
			request.url(), request.headers()));

		Response response = chain.proceed(request);

		long t2 = System.nanoTime();
		Log.d(TAG,String.format("Received response for %s in %.1fms%n%s",
			response.request().url(), (t2 - t1) / 1e6d, response.headers()));


		final String responseString = new String(response.body().bytes());

		Log.d(TAG,"Response: " + responseString);

		return  response.newBuilder()
			.body(ResponseBody.create(response.body().contentType(), responseString))
			.build();
	}
}

