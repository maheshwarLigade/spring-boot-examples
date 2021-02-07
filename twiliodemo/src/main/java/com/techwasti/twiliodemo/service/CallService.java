package com.techwasti.twiliodemo.service;


import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Client;
import com.twilio.twiml.voice.Dial;
import com.twilio.twiml.voice.Number;
import com.twilio.twiml.voice.Say;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.techwasti.twiliodemo.util.Constants;

@Service
public class CallService {


    @Value("${twilio.trial_number}")
    private String calledId;

    public String createVoiceResponse(String to) {
        VoiceResponse voiceTwimlResponse;

        if (to != null) {

            Dial.Builder dialBuilder = new Dial.Builder()
                    .callerId(calledId);

            Dial.Builder dialBuilderWithReceiver = addChildReceiver(dialBuilder, to);

            voiceTwimlResponse = new VoiceResponse.Builder()
                    .dial(dialBuilderWithReceiver.build())
                    .build();

        } else {
            voiceTwimlResponse = new VoiceResponse.Builder()
                    .say(new Say.Builder(Constants.DEFAULT_CALL_MESSAGE).build())
                    .build();
        }

        return voiceTwimlResponse.toXml();
    }

    public String getRedirectToClientVoiceResponse() {
        VoiceResponse voiceTwimlResponse;

        Say say = new Say.Builder(Constants.REDIRECT_WAIT_MESSAGE).build();
        Client client = new Client.Builder(Constants.current_logged_user).build();
        Dial dial = new Dial.Builder().client(client).build();

        voiceTwimlResponse = new VoiceResponse.Builder().say(say).dial(dial).build();
        return voiceTwimlResponse.toXml();
    }


    private Dial.Builder addChildReceiver(Dial.Builder builder, String to) {
        
        if (isPhoneNumber(to)) {
            return builder.number(new Number.Builder(to).build());
        }
        return builder.client(new Client.Builder(to).build());
    }
    
    //validate the phone number 
    private boolean isPhoneNumber(String to) {
        return to.matches("^[\\d\\+\\-\\(\\) ]+$");
    }
}
