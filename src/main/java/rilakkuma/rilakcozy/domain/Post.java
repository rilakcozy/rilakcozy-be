package rilakkuma.rilakcozy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @Column(name="post_id", updatable=false)
    private Long post_id;

    @Column(name="category_id", updatable=false)
    private Long category_id;

    @Column(name="title", updatable = true)
    private String title;

    @Column(name="content", updatable = true)
    private String content;

    @Column(name="user_id", updatable = false)
    private String user_id;

    @CreatedDate //엔티티가 생성될 때 생성 시간 저장
    @Column(name= "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate //엔티티가 수정될 때 수정 시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder //빌더 패턴으로 객체 생성
    public Post(Long post_id, Long category_id, String title, String content, String user_id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.post_id = post_id;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }



}
