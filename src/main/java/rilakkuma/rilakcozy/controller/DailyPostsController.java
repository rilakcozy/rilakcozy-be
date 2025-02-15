package rilakkuma.rilakcozy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rilakkuma.rilakcozy.common.ApiResponse;
import rilakkuma.rilakcozy.domain.Post;
import rilakkuma.rilakcozy.dto.AddPostRequest;
import rilakkuma.rilakcozy.dto.EditPostRequest;
import rilakkuma.rilakcozy.dto.PostResponse;
import rilakkuma.rilakcozy.service.PostService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/posts")
public class DailyPostsController {
    private final PostService postService;

    @GetMapping("/daily")
    public ResponseEntity<ApiResponse<List<PostResponse>>> findAllDailyPosts(){
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();

        return ResponseEntity.ok().body(
                ApiResponse.success(
                        HttpStatus.OK.value(),
                        "success to view daily post",
                        posts));
    }

    @PostMapping("/daily")
    public ResponseEntity<ApiResponse<Post>> addDailyPost(@RequestBody AddPostRequest request){
        Post savedPost = postService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(HttpStatus.CREATED.value(),"success to daily post", savedPost));
    }

    @PatchMapping("/daily/{categoryId}/{postId}")
    public ResponseEntity<Post> editDailyPost(@PathVariable long categoryId, @PathVariable long postId, @RequestBody EditPostRequest request){
        Post editPost = postService.edit(categoryId, postId, request);

        return ResponseEntity.ok().body(editPost);
    }
}
