package rilakkuma.rilakcozy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rilakkuma.rilakcozy.domain.Post;
import rilakkuma.rilakcozy.dto.AddPostRequest;
import rilakkuma.rilakcozy.dto.EditPostRequest;
import rilakkuma.rilakcozy.repository.PostCategorysRepository;
import rilakkuma.rilakcozy.repository.PostRepository;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service //빈으로 등록
public class PostService extends PostServiceImpl {

    @Autowired
    private final PostRepository postRepository;
    private final PostCategorysRepository postCategorysRepository;

    //게시판 글 전체 조회 메서드
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    //게시판 글 저장
    public Post save(AddPostRequest request){

//        PostCategorys postCategorys = postCategorysRepository.findByCategoryId(request.getCategoryId())
//                .orElseThrow(() -> new IllegalArgumentException("Not exist this category"));


        return postRepository.save(request.toEntity());
    }

    //게시판 글 수정
    @Transactional
    public Post edit( long categoryId, long postId, EditPostRequest request) {
        Post post = postRepository.findByCategoryIdAndPostId(categoryId,postId)
                .orElseThrow();

        post.update(request.getTitle(), request.getContent(), request.getUpdatedAt());

        return post;
    }

    @Transactional
    public void deleteByCategoryIdAndPostId(long categoryId, long postId){
        postRepository.deleteByCategoryIdAndPostId(categoryId, postId);
    }
}
