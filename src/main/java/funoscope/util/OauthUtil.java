package funoscope.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthRequest;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import com.sun.jersey.oauth.signature.OAuthSignature;
import com.sun.jersey.oauth.signature.OAuthSignatureException;

import funoscope.web.adapter.OAuthServletRequestWrapper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.QueryStringSigningStrategy;

@Service
public class OauthUtil {

    private final static String OAUTH_REALM = "OAuth realm";
    private final static String OAUTH_NONCE = "oauth_nonce";
    private final static String OAUTH_TIMESTAMP = "oauth_timestamp";
    private final static String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    private final static String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    private final static String OAUTH_VERSION = "oauth_version";
    private final static String OAUTH_SIGNATURE = "oauth_signature";

    public static Boolean isValid(String pUrl, String pConsumerKey, String pSecret, String pHeader,
                                  HttpServletRequest pHttpServletRequest) throws OAuthMessageSignerException, OAuthExpectationFailedException,
                                                                          OAuthCommunicationException, OAuthSignatureException {

        OAuthParameters oauthParameters = OauthUtil.populateFromHeader(pHeader);

        System.out.println("Request Consumer Key: " + oauthParameters.getConsumerKey());
        System.out.println("Request Signature: " + oauthParameters.getSignature());

        OAuthSecrets secrets = new OAuthSecrets();
        secrets.consumerSecret(pSecret);
        OAuthRequest request = new OAuthServletRequestWrapper(pHttpServletRequest);

        return OAuthSignature.verify(request, oauthParameters, secrets);
    }

    public static String signUrl(String pUrl, String pConsumerKey, String pSecret) throws OAuthCommunicationException, OAuthExpectationFailedException,
                                                                                   OAuthMessageSignerException {

        OAuthConsumer consumer = new DefaultOAuthConsumer(pConsumerKey, pSecret);
        consumer.setSigningStrategy(new QueryStringSigningStrategy());

        return consumer.sign(pUrl);
    }

    public static OAuthParameters populateFromHeader(String pHeader) {
        OAuthParameters oAuthParameters = new OAuthParameters();
        String[] authParams = pHeader.replace("\"", "").split(",");
        for (int i = 0; i < authParams.length; i++) {
            int sepratorIndex = authParams[i].indexOf("=");
            String key = authParams[i].substring(0, sepratorIndex).trim();
            if (!key.equals(authParams[i])) {
                String value = authParams[i].substring(sepratorIndex + 1);

                if (key.equals(OAUTH_CONSUMER_KEY)) {
                    oAuthParameters.setConsumerKey(value);
                } else if (key.equals(OAUTH_SIGNATURE)) {
                    oAuthParameters.setSignature(value);
                } else if (key.equals(OAUTH_REALM)) {
                    oAuthParameters.setRealm(value);
                } else if (key.equals(OAUTH_NONCE)) {
                    oAuthParameters.setNonce(value);
                } else if (key.equals(OAUTH_TIMESTAMP)) {
                    oAuthParameters.setTimestamp(value);
                } else if (key.equals(OAUTH_SIGNATURE_METHOD)) {
                    oAuthParameters.setSignatureMethod(value);
                } else if (key.equals(OAUTH_VERSION)) {
                    oAuthParameters.setVersion(value);
                }
            }
        }

        return oAuthParameters;
    }
}
