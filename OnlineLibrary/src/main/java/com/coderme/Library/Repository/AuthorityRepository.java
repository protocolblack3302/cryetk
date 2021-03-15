package com.coderme.Library.Repository;

import com.coderme.Library.Domains.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authorities, String> {
}
