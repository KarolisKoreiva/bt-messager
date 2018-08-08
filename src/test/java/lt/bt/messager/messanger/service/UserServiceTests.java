package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void shouldReturnCurrentUserId() {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(new Long(1));
        Authentication authentication = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "jonas";
            }
        };

        SecurityContext securityContext = new SecurityContext() {
            private Authentication authentication;
            @Override
            public Authentication getAuthentication() {
                return this.authentication;
            }

            @Override
            public void setAuthentication(Authentication authentication) {
                this.authentication = authentication;
            }
        };

        securityContext.setAuthentication(authentication);

        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findByUsername("jonas")).thenReturn(userEntity);

        Long userId = userService.getCurrentUserId();

        assertEquals(new Long(1), userId);

    }
}
