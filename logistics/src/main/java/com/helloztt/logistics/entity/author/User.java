package com.helloztt.logistics.entity.author;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by helloztt on 2016/6/20.
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@Cacheable(value = false)
public class User implements Serializable,UserDetails {
    private static final long serialVersionUID = 2225663254150736620L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
    /**
     * 是否冻结
     */
    @Column(name = "Disabled")
    private boolean disabled;
    /**
     * 是否删除
     */
    @Column(name = "Deleted")
    private boolean deleted;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //todo add authority
        return Arrays.asList(
        );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.disabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.deleted;
    }

    public User getUser(){
        return this;
    }
}
