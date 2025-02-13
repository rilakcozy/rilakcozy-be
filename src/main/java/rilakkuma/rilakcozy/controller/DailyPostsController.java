package rilakkuma.rilakcozy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rilakkuma.rilakcozy.domain.Post;
import rilakkuma.rilakcozy.dto.AddPostRequest;
import rilakkuma.rilakcozy.dto.PostResponse;
import rilakkuma.rilakcozy.service.PostService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DailyPostsController {
    private final PostService postService;

    @GetMapping("api/posts/daily")
    public ResponseEntity<List<PostResponse>> findAllDailyPosts(){
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();

        return ResponseEntity.ok().body(posts);
    }

    @PostMapping("api/posts/daily")
    public ResponseEntity<Post> addDailyPost(@RequestBody AddPostRequest request){
        Post savedPost = postService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPost);
    }
}
