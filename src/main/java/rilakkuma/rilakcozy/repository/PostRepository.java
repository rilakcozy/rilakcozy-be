package rilakkuma.rilakcozy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rilakkuma.rilakcozy.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
