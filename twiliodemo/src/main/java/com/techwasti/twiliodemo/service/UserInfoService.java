package com.techwasti.twiliodemo.service;


import com.github.javafaker.Faker;
import com.techwasti.twiliodemo.model.UserInfo;
import com.techwasti.twiliodemo.util.Constants;
import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.VoiceGrant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class UserInfoService {

    @Value("${twilio.account_sid}")
    private String acctSid;

    @Value("${twilio.twiml.app.sid}")
    private String applicationSid;

    @Value("${twilio.api.key}")
    private String apiKey;

    @Value("${twilio.api.secret}")
    private String apiSecret;

    public UserInfo createToken(){
        String identify = generateIdentity();
        return createJsonAccessToken(identify);
    }


    private String generateIdentity() {
        // Create a Faker instance to generate a random username for the connecting user
        Faker faker = new Faker();
        String current_user_name = faker.name().firstName() + faker.phoneNumber().extension();
        Constants.current_logged_user = current_user_name;
        return current_user_name;
    }

    private UserInfo createJsonAccessToken(String identity) {
        UserInfo user = new UserInfo();
        
        VoiceGrant grant = new VoiceGrant();
        grant.setOutgoingApplicationSid(applicationSid);

        // Optional: add to allow incoming calls
        grant.setIncomingAllow(true);

        // Create access token
        AccessToken accessToken = new AccessToken.Builder(acctSid, apiKey, apiSecret)
                .identity(identity)
                .grant(grant)
                .build();

        String token = accessToken.toJwt();
        
        user.setIdentity(identity);
        user.setToken(token);

        return user;
    }
}
