package mumage.mumagebackend.service;

import mumage.mumagebackend.domain.User;
import mumage.mumagebackend.dto.UserJoinDto;
import mumage.mumagebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

    @Transactional
    public class UserService {

        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        /*
        회원 가입 : create
         */
        public User join(UserJoinDto userJoinDto) {

            User user = new User();
            user.setLoginId(userJoinDto.getUserId());
            user.setPassword(userJoinDto.getPassword());
            user.setName(userJoinDto.getName());
            user.setNickname(userJoinDto.getNickname());
            userRepository.save(user);
            return user;
        }

        /*
        회원 탈퇴 : delete
         */
        public boolean withdraw(Long id) {
            Optional<User> member = userRepository.findById(id);
            if (member.isPresent()) {
                userRepository.delete(member.get());
                return true;
            } else {
                return false;
            }
        }

    /*
    중복 조회
     */

        // 아이디
        public boolean existLoginId(String loginId) {
            Optional<User> byLoginId = userRepository.findByLoginId(loginId);
            if (byLoginId.isPresent()) {
                return true;
            } else {
                return false;
            }
        }

        // 닉네임
        public boolean existNickname(String nickname) {
            Optional<User> byNickname = userRepository.findByNickname(nickname);
            if (byNickname.isPresent()) {
                return true;
            } else {
                return false;
            }
        }

        /*
        전체 회원 조회
         */
        public List<User> findMembers() {
            return userRepository.findAll();
        }

        /*
        특정 회원 조회
         */
        public Optional<User> findById(Long userId) {
            return userRepository.findById(userId);
        }

    }
}
