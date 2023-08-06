package restservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restservice.demo.entity.Chat;

import java.util.List;


@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByFromUser(String fromUser);

    List<Chat> findByToUser(String toUser);
    List<Chat> findByFromUserAndToUser(String fromUser, String toUser);
}