package ru.boshchenko.rtz_app.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class RtzAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            System.out.println("Невозможно перенаправить, так как ответ уже отправлен");
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isManager = false;
        boolean isStorekeeper = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if (authorityName.equals("ROLE_USER")) {
                isUser = true;
                break;
            } else if (authorityName.equals("ROLE_MANAGER")) {
                isManager = true;
                break;
            } else if (authorityName.equals("ROLE_STOREKEEPER")) {
                isStorekeeper = true;
                break;
            }
        }
        if (isUser) {
            return "/client_main.html";
        } else if (isManager) {
            return "/manager_main.html";
        } else if (isStorekeeper) {
            return "/storekeeper_main.html";
        } else {
            throw new IllegalStateException("Роль пользователя не распознана");
        }
    }
}
