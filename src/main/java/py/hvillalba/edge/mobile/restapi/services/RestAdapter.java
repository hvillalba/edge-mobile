/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.edge.mobile.restapi.services;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 *
 * @author hectorvillalba
 */
public class RestAdapter {
  private static Retrofit retrofit = null;
    private static String token = "";

    public static Retrofit getClient() {

        // Retrofit
        if (retrofit == null) {
                retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                    .client(getUnsafeOkHttpClient().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    
    /**
     * Obtenemos el cliente HTTP
     * @return
     */
    private static OkHttpClient getHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        //.addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        });
        // Establecemos el timeout
        builder.connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS);

        return builder.build();
    }
    
    
    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            // Creamos el interceptor
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = null;
                    if(token.isEmpty()){
                        newRequest  = chain.request().newBuilder().build();
                    }else{
                        newRequest  = chain.request().newBuilder().addHeader("Authorization", token).build();
                    }
                    return chain.proceed(newRequest);
                }
            });
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            //builder.sslSocketFactory(sslSocketFactory, );
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

