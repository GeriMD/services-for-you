package com.example.servicesforyou.user;

import com.example.servicesforyou.models.user.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserDetailsTest {
    @Test
    public void userDetailsTest() {
        Long userId = Long.valueOf(1);
        String username = "test@abv.bg";
        String password = "123456";
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        Collection<GrantedAuthority> authorities;
        authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

        MyUserDetails userDetails = new MyUserDetails(userId, password, username, firstName, lastName, authorities);

        assertEquals(userId, userDetails.getId());
        assertEquals(password, userDetails.getPassword());
        assertEquals(username, userDetails.getUsername());
        assertEquals(firstName, userDetails.getFirstName());
        assertEquals(lastName, userDetails.getLastName());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));

        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertTrue(userDetails.isEnabled());
    }
}
