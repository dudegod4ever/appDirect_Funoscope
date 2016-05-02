package funoscope.util;

import org.springframework.stereotype.Service;

import funoscope.web.context.OauthContext;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.QueryStringSigningStrategy;

@Service
public class OauthUtil {


    public static Boolean isValid(String pUrl, String pConsumerKey, String pSecret,
                                  String pRequestSignature) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
        Boolean result = false;

        String signatureValidation = signUrl(pUrl, pConsumerKey, pSecret);
        OauthContext context = new OauthContext();
        context.populateFromUrl(signatureValidation);

        if (context.getSignature().equals(pRequestSignature)) {
            result = true;
        }

        return result;
    }

    public static String signUrl(String pUrl, String pConsumerKey, String pSecret) throws OAuthCommunicationException, OAuthExpectationFailedException,
                                                                                   OAuthMessageSignerException {

        OAuthConsumer consumer = new DefaultOAuthConsumer(pConsumerKey, pSecret);
        consumer.setSigningStrategy(new QueryStringSigningStrategy());

        return consumer.sign(pUrl);
    }
}
