package re.st.animalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.st.animalshelter.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByChatId(long chatId);
    User findUserByUserNameOrEmailOrPassport(String userName, String email, String passport);
}
