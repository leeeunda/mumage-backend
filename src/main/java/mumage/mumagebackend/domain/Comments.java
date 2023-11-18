package mumage.mumagebackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*; //javax->jarkarta

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue
    @Column(name = "comments_id")
    private Long id;

    private String content; // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    private Posts posts; // 댓글 작성된 게시글

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 댓글 작성자

    @Builder
    public Comments(String content, Posts posts, User user){
        this.content = content;
        this.posts = posts;
        this.user = user;
    }

}
