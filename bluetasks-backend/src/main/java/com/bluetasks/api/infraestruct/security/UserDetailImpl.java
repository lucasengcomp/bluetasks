package com.bluetasks.api.infraestruct.security;


import java.util.Collection;

import com.bluetasks.api.domain.user.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UserDetailImpl implements UserDetails {

    private String username;
    private String password;
    private String displayName;

    public UserDetailImpl(AppUser appUser) {
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
        this.displayName = appUser.getDisplayName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.NO_AUTHORITIES;
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

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}