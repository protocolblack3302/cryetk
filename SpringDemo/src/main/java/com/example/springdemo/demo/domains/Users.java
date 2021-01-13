package com.example.springdemo.demo.domains;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@RequiredArgsConstructor
public class Users implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name="username",nullable = false)
    private String username;
  @Column(name="password",nullable = false)
  private String password;
  @Column(name="enabled",nullable = false,columnDefinition = "boolean default true")
  private Boolean enabled=true;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
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


  public Users justEncode(PasswordEncoder passwordEncoder){
    this.setPassword(passwordEncoder.encode(getPassword()));
    return this;
  }

}
