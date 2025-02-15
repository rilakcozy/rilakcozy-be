package rilakkuma.rilakcozy.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import rilakkuma.rilakcozy.repository.CustomPostRepository;
import rilakkuma.rilakcozy.repository.PostRepository;

public class PostServiceImpl implements CustomPostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteByCategoryIdAndPostId(long categoryId, long postId){
        entityManager.createQuery("DELETE FROM post p WHERE p.category_id = :category_id AND p.post_id = :post_id")
                .setParameter("category_id", categoryId)
                .setParameter("post_id", postId)
                .executeUpdate();
    }
}
