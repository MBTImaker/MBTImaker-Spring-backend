package project.mbti.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ClientIpExtracter {

    public String extract(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null) {
            clientIp = request.getHeader("Proxy-Client-IP");
            if (clientIp == null) {
                clientIp = request.getHeader("WL-Proxy-Client-IP");
                if (clientIp == null) {
                    clientIp = request.getHeader("HTTP_CLIENT_IP");
                    if (clientIp == null) {
                        clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
                        if (clientIp == null)
                            clientIp = request.getRemoteAddr();
                    }
                }
            }
        }

        return clientIp;
    }
}
