package mumage.mumagebackend.Config;

import mumage.mumagebackend.service.*;
import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class HomeConfig implements WebMvcConfigurer {

    private final CommentsService commentsService;
    private final PostsService postsService;
    private final Userervice Userervice;
    private final FollowService followService;
    private final LikesService likesService;

    //인코더 빈 객체 등록
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //로그인 인터셉터 : 로그인 안 했을 시 로그인 하도록 유도
//        registry.addInterceptor(new HomeInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/")
//                .excludePathPatterns("/icon/**")
//                .excludePathPatterns("/uploads/**")
//                .excludePathPatterns("/user/login")
//                .excludePathPatterns("/user/doLogin")
//                .excludePathPatterns("/user/signIn");
//        //댓글 삭제 인터셉터 : 로그인 한 사람과 댓글 단 사람이 다른 경우 방지
//        registry.addInterceptor(new CommentDeleteInterceptor(commentsService))
//                .addPathPatterns("/comment/delete/**");
//        //게시글 수정 & 삭제 인터셉터 : 로그인 한 사람과 게시글 작성자가 다른 경우 방지
//        registry.addInterceptor(new PostInterceptor(postsService))
//                .addPathPatterns("/post/delete/**")
//                .addPathPatterns("/post/update/**");
//        //회원 수정 & 삭제 인터셉터 : 로그인 한 사람과 수정하려는 회원이 다른 경우 방지
//        registry.addInterceptor(new UserInterceptor(Userervice))
//                .addPathPatterns("/user/update/**")
//                .addPathPatterns("/user/delete/**");
//        // 팔로우 인터셉터 : 이미 팔로우 한 경우 다시 팔로우 하는 걸 방지
//        registry.addInterceptor(new FollowInterceptor(followService,Userervice))
//                .addPathPatterns("/follow/**")
//                .excludePathPatterns("/follow/already");
//        // 좋아요 인터셉터 : 이미 좋아요 한 경우 다시 좋아요 하는 걸 방지
//        registry.addInterceptor(new LikesInterceptor(likesService,Userervice,postsService))
//                .addPathPatterns("/likes/save/**");
//        // 글 작성 인터셉터 : 특정 ip로 작성한 글 차단
//        registry.addInterceptor(new PostWriteInterceptor(ipBanService))
//                .addPathPatterns("/post/write/**");
//    }

}
