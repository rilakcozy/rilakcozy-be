package rilakkuma.rilakcozy.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="postId", updatable=false)
    private Long postId;

    @Column(name="categoryId", updatable=false)
    private Long categoryId;

    @Column(name="title", updatable = true)
    private String title;

    @Column(name="content", updatable = true)
    private String content;

    @Column(name="userId", updatable = false)
    private String userId;

    @CreatedDate //엔티티가 생성될 때 생성 시간 저장
    @Column(name= "createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate //엔티티가 수정될 때 수정 시간 저장
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Builder //빌더 패턴으로 객체 생성
    public Post(Long postId, Long categoryId, String title, String content, String userId, LocalDateTime createdAt) {
        this.postId = postId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
    }

    public void update(String title, String content, LocalDateTime updatedAt){
        this.title = title;
        this.content = content;
        this.updatedAt = updatedAt;
    }
}
