package com.example.cinemahoanghuy.security;


import com.example.cinemahoanghuy.entity.Permission;
import com.example.cinemahoanghuy.entity.Role;
import com.example.cinemahoanghuy.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserPrincipal implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities ;




    public UserPrincipal(Long id, String username, String password, Collection<SimpleGrantedAuthority> authorities) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal build(User user){

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role :user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            for (Permission permission : role.getPermissions()){
                grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
            }
        }
        return new UserPrincipal(user.getId(),user.getUsername(),user.getPassword(),grantedAuthorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
