package rilakkuma.rilakcozy.repository;

public interface CustomPostRepository {
    void deleteByCategoryIdAndPostId(long categoryId, long postId);
}
