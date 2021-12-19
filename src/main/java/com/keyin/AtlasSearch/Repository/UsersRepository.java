package com.keyin.AtlasSearch.Repository;

import com.keyin.AtlasSearch.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends JpaRepository<User, Long> {
    @Query("SELECT FROM User where EMAIL =$1")
    User findByEmail(String Email);

}
