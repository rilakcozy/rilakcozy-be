package rilakkuma.rilakcozy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rilakkuma.rilakcozy.domain.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Long findByCategoryId(long categoryId);
    Optional<Post> findByCategoryIdAndPostId(long categoryId, long postId);
}
