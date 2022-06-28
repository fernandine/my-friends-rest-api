package digytal.myfriends.restapi.repository;

import digytal.myfriends.restapi.model.Friend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    //REPRESENTA O LIKE NO BANCO
    Page<Friend> findByNameContaining(String name, Pageable pageable);
}
