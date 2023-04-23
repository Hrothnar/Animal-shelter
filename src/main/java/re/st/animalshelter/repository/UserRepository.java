package re.st.animalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.st.animalshelter.model.entity.Dialog;
import re.st.animalshelter.model.entity.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByChatId(long chatId);
}
