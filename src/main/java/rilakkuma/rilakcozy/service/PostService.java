package rilakkuma.rilakcozy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rilakkuma.rilakcozy.domain.Post;
import rilakkuma.rilakcozy.dto.AddPostRequest;
import rilakkuma.rilakcozy.repository.PostRepository;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service //빈으로 등록
public class PostService {
    private final PostRepository postRepository;

    //게시판 글 전체 조회 메서드
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    //게시판 글 저장
    public Post save(AddPostRequest request){
        return postRepository.save(request.toEntity());
    }

}
