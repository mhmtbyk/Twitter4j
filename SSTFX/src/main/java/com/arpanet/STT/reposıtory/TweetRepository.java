package com.arpanet.STT.reposıtory;

import com.arpanet.STT.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("FROM Tweet WHERE userName = ?1")
    List<Tweet> findByUserName(String userName);
}
