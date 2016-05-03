package funoscope.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthRequest;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import com.sun.jersey.oauth.signature.OAuthSignature;
import com.sun.jersey.oauth.signature.OAuthSignatureException;

import funoscope.web.WebConstants;
import funoscope.web.adapter.OAuthServletRequestWrapper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.QueryStringSigningStrategy;

@Service
public class OauthUtil {

    private final static String OAUTH_START = "OAuth ";

    private final static String OAUTH_REALM = "OAuth realm";
    private final static String OAUTH_NONCE = "oauth_nonce";
    private final static String OAUTH_TIMESTAMP = "oauth_timestamp";
    private final static String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    private final static String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    private final static String OAUTH_VERSION = "oauth_version";
    private final static String OAUTH_SIGNATURE = "oauth_signature";

    public static boolean isValid(String pUrl, String pConsumerKey, String pSecret, String pHeader,
                                  HttpServletRequest pHttpServletRequest) throws OAuthMessageSignerException, OAuthExpectationFailedException,
                                                                          OAuthCommunicationException, OAuthSignatureException {

        OAuthParameters oauthParameters = OauthUtil.populateFromHeader(pHeader);
        OAuthSecrets secrets = new OAuthSecrets();
        secrets.consumerSecret(pSecret);
        OAuthRequest request = new OAuthServletRequestWrapper(pHttpServletRequest);

        boolean result = OAuthSignature.verify(request, oauthParameters, secrets);

        if (result == false) {
            //help me debug this
            System.out.println("****** OAUTH PARAM ********");
            System.out.println("oauthParameters Consumer Key: " + oauthParameters.getConsumerKey());
            System.out.println("oauthParameters Signature: " + oauthParameters.getSignature());
            System.out.println("oauthParameters Signature Method: " + oauthParameters.getSignatureMethod());
            System.out.println("oauthParameters NONCE : " + oauthParameters.getNonce());
            System.out.println("oauthParameters REALM : " + oauthParameters.getRealm());
            System.out.println("oauthParameters TIMESTAMP : " + oauthParameters.getTimestamp());
            System.out.println("oauthParameters VERSION : " + oauthParameters.getVersion());

            System.out.println("Target URL: " + pUrl);
            System.out.println("Request Header: " + pHeader);
            System.out.println("Consumer Key: " + pConsumerKey);
            System.out.println("Secret Key: " + pSecret);

            System.out.println("RESULT : " + result);

            if (System.getProperty(WebConstants.SKIP_AUTH_VALIDATION) != null) {
                System.out.println("skipping oauth validation because it has failed!!!");
                return true;
            }

        }

        return result;
    }

    public static String signUrl(String pUrl, String pConsumerKey, String pSecret) throws OAuthCommunicationException, OAuthExpectationFailedException,
                                                                                   OAuthMessageSignerException {

        if (System.getProperty(WebConstants.SKIP_AUTH_VALIDATION) != null) {
            return pUrl;
        }

        System.out.println("skipping oauth signature");

        OAuthConsumer consumer = new DefaultOAuthConsumer(pConsumerKey, pSecret);
        consumer.setSigningStrategy(new QueryStringSigningStrategy());

        return consumer.sign(pUrl);
    }

    public static OAuthParameters populateFromHeader(String pHeader) {
        String header = pHeader;
        if (pHeader.startsWith(OAUTH_START)) {
            header = header.replaceFirst(OAUTH_START, "");
        }
        OAuthParameters oAuthParameters = new OAuthParameters();
        String[] authParams = header.replace("\"", "").split(",");
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
