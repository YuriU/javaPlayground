package dev.example.yuriiu;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import java.util.HashSet;
import java.util.Set;

public class SayHelloRequestStreamHandler extends SkillStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://www.amazon.com/ap/signin?openid.pape.preferred_auth_policies=Singlefactor&openid.pape.max_auth_age=7200&openid.return_to=https%3A%2F%2Fdeveloper.amazon.com%2Falexa%2Fconsole%2Fask&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=amzn_dante_us&openid.mode=checkid_setup&marketPlaceId=ATVPDKIKX0DER&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&#/
         * "Edit" the relevant Alexa Skill and put the relevant Application Ids
         * in this Set.
         */
        supportedApplicationIds = new HashSet<String>();
        //supportedApplicationIds.add("[Add your Alexa Skill ID and then uncomment and ]";
        System.out.println("Supported app ids : " + supportedApplicationIds);
    }

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new CancelAndStopIntentHandler(),
                        new SessionEndedHandler(),
                        new HelpIntentHandler(),
                        new SayHelloIntentHandler()
                )
                .build();
    }

    public SayHelloRequestStreamHandler() {
        super(getSkill());
    }
}
