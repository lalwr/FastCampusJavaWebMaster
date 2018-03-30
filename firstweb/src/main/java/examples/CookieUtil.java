package examples;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie c = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(name.equals(cookie.getName())){
                    c = cookie;
                    break;
                }
            }
        }
        return c;
    }
}
