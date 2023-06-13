package giterDone.repository;
import com.giterDone.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoList,Long> {
}
