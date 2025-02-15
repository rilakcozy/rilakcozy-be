package rilakkuma.rilakcozy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EditPostRequest {
        private String title;
        private String content;
        private LocalDateTime updatedAt;
}
