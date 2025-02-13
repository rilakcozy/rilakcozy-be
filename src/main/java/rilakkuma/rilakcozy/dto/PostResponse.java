package rilakkuma.rilakcozy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rilakkuma.rilakcozy.domain.Post;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostResponse {
    private Long post_id;
    private Long category_id;
    private String title;
    private String content;
    private String user_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public PostResponse(Post post) {
        this.post_id = post.getPost_id();
        this.category_id = post.getCategory_id();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.user_id = post.getUser_id();
        this.created_at = post.getCreatedAt();
        this.updated_at = post.getUpdatedAt();
    }
}
