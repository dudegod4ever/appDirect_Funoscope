package funoscope.web.adapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.sun.jersey.oauth.signature.OAuthRequest;

public class OAuthServletRequestWrapper implements OAuthRequest {
    private HttpServletRequest request;

    public OAuthServletRequestWrapper(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getRequestMethod() {
        return request.getMethod();
    }

    @Override
    public URL getRequestURL() {
        URL url = null;
        try {
            url = new URL(request.getRequestURL().toString());
        } catch (MalformedURLException ex) {
            //url will be null
        }

        return url;
    }

    @Override
    public Set<String> getParameterNames() {
        return new HashSet(Collections.list(request.getParameterNames()));
    }

    @Override
    public List<String> getParameterValues(String name) {
        return Arrays.asList(request.getParameterValues(name));
    }

    @Override
    public List<String> getHeaderValues(String name) {
        return Collections.list(request.getHeaders(name));
    }

    @Override
    public void addHeaderValue(String name, String value) throws IllegalStateException {
        throw new IllegalStateException("OAuthServletRequest modification not supported");
    }
}
