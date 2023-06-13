package giterDone.repository;
import com.giterDone.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projectRepository<project> extends JpaRepository<project,Long> {
}
