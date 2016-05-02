package funoscope.web.context;

import org.apache.commons.lang3.StringUtils;

public class OauthContext {

    private final static String OAUTH_REALM = "OAuth realm";
    private final static String OAUTH_NONCE = "oauth_nonce";
    private final static String OAUTH_TIMESTAMP = "oauth_timestamp";
    private final static String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    private final static String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    private final static String OAUTH_VERSION = "oauth_version";
    private final static String OAUTH_SIGNATURE = "oauth_signature";

    private String realm = StringUtils.EMPTY;
    private String nonce = StringUtils.EMPTY;
    private String timestamp = StringUtils.EMPTY;
    private String consumerKey = StringUtils.EMPTY;
    private String signature = StringUtils.EMPTY;
    private String signatureMethod = StringUtils.EMPTY;
    private String version = StringUtils.EMPTY;

    public OauthContext() {

    }

    public void populateFromUrl(String pUrl) {
        String[] urlParams = pUrl.replace("\"", "").split("\\?");
        if (urlParams.length == 2 && StringUtils.isNotEmpty(urlParams[1])) {
            String[] authParams = urlParams[1].replace("\"", "").split("\\&");
            for (int i = 0; i < authParams.length; i++) {
                int sepratorIndex = authParams[i].indexOf("=");
                String key = authParams[i].substring(0, sepratorIndex).trim();
                if (!key.equals(authParams[i])) {
                    String value = authParams[i].substring(sepratorIndex + 1);

                    if (key.equals(OAUTH_CONSUMER_KEY)) {
                        consumerKey = value;
                    } else if (key.equals(OAUTH_SIGNATURE)) {
                        signature = value;
                    } else if (key.equals(OAUTH_REALM)) {
                        realm = value;
                    } else if (key.equals(OAUTH_NONCE)) {
                        nonce = value;
                    } else if (key.equals(OAUTH_TIMESTAMP)) {
                        timestamp = value;
                    } else if (key.equals(OAUTH_SIGNATURE_METHOD)) {
                        signatureMethod = value;
                    } else if (key.equals(OAUTH_VERSION)) {
                        version = value;
                    }
                }
            }
        }
    }

    public void populateFromHeader(String pUrl) {
        String[] authParams = pUrl.replace("\"", "").split(",");
        for (int i = 0; i < authParams.length; i++) {
            int sepratorIndex = authParams[i].indexOf("=");
            String key = authParams[i].substring(0, sepratorIndex).trim();
            if (!key.equals(authParams[i])) {
                String value = authParams[i].substring(sepratorIndex + 1);

                if (key.equals(OAUTH_CONSUMER_KEY)) {
                    consumerKey = value;
                } else if (key.equals(OAUTH_SIGNATURE)) {
                    signature = value;
                } else if (key.equals(OAUTH_REALM)) {
                    realm = value;
                } else if (key.equals(OAUTH_NONCE)) {
                    nonce = value;
                } else if (key.equals(OAUTH_TIMESTAMP)) {
                    timestamp = value;
                } else if (key.equals(OAUTH_SIGNATURE_METHOD)) {
                    signatureMethod = value;
                } else if (key.equals(OAUTH_VERSION)) {
                    version = value;
                }
            }
        }
    }

    public String getHeader() {

        StringBuffer buf = new StringBuffer();
        buf.append(OAUTH_REALM).append("=\"").append(realm).append("\",");
        buf.append(OAUTH_NONCE).append("=\"").append(nonce).append("\",");
        buf.append(OAUTH_TIMESTAMP).append("=\"").append(timestamp).append("\",");
        buf.append(OAUTH_CONSUMER_KEY).append("=\"").append(consumerKey).append("\",");
        buf.append(OAUTH_SIGNATURE_METHOD).append("=\"").append(signatureMethod).append("\",");
        buf.append(OAUTH_VERSION).append("=\"").append(version).append("\",");
        buf.append(OAUTH_SIGNATURE).append("=\"").append(signature).append("\",");

        return buf.toString();

    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String pRealm) {
        realm = pRealm;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String pNonce) {
        nonce = pNonce;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String pTimestamp) {
        timestamp = pTimestamp;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String pConsumerKey) {
        consumerKey = pConsumerKey;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String pSignature) {
        signature = pSignature;
    }

    public String getSignatureMethod() {
        return signatureMethod;
    }

    public void setSignatureMethod(String pSignatureMethod) {
        signatureMethod = pSignatureMethod;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String pVersion) {
        version = pVersion;
    }

}
