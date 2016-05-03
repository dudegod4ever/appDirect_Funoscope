package funoscope.web.adapter;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
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
        StringBuilder urlBuilder = new StringBuilder();

        try {
            String scheme = request.getScheme();
            String serverName = request.getServerName();
            int serverPort = request.getServerPort();
            String contextPath = request.getContextPath();
            String servletPath = request.getServletPath();
            String pathInfo = request.getPathInfo();
            String queryString = request.getQueryString();

            // Reconstruct original requesting URL
            urlBuilder.append(scheme).append("://").append(serverName);

            if (serverPort != 80 && serverPort != 443) {
                urlBuilder.append(":").append(serverPort);
            }

            urlBuilder.append(contextPath).append(servletPath);

            if (pathInfo != null) {
                urlBuilder.append(pathInfo);
            }
            if (queryString != null) {
                urlBuilder.append("?").append(queryString);
            }

            url = new URL(URLDecoder.decode(urlBuilder.toString(), StandardCharsets.UTF_8.name()));
            System.out.println("builded URl :" + url);

        } catch (MalformedURLException | UnsupportedEncodingException ex) {
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
