package rilakkuma.rilakcozy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rilakkuma.rilakcozy.domain.Post;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPostRequest {
    private Long categoryId;
    private Long postId;
    private String title;
    private String content;
    private String userId;
    private LocalDateTime createdAt;
//    private LocalDateTime updated_at;

    public Post toEntity() {

        return Post.builder()
                .categoryId(categoryId)
                .postId(postId)
                .title(title)
                .content(content)
                .userId(userId)
                .createdAt(createdAt)
                .build();

    }
}
