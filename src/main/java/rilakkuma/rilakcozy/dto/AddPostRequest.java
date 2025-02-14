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
    private Long post_id;
    private Long category_id;
    private String title;
    private String content;
    private String user_id;
    private LocalDateTime created_at;
//    private LocalDateTime updated_at;

    public Post toEntity() {
        return Post.builder()
                .post_id(post_id)
                .category_id(category_id)
                .title(title)
                .content(content)
                .user_id(user_id)
                .createdAt(created_at)
                .build();

    }
}
