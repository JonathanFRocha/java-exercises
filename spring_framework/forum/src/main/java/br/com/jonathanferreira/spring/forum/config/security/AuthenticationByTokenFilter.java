package br.com.jonathanferreira.spring.forum.config.security;

import br.com.jonathanferreira.spring.forum.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AuthenticationByTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository repository;

    public AuthenticationByTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.repository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getToken(request);
        boolean valid = tokenService.isValidToken(token);
        if(valid){
            authenticateUser(token);
        }
        filterChain.doFilter(request,response);
    }

    private void authenticateUser(String token) {
        int idUser = tokenService.getUserId(token);
        var optUser = repository.findById(idUser);
        if(optUser.isEmpty()){
            System.out.println("no user here");
        }else {
            var user = optUser.get();
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || !token.startsWith("Bearer")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
