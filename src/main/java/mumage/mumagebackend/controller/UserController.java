package mumage.mumagebackend.controller;

import jakarta.validation.Valid;
import mumage.mumagebackend.dto.MessageDto;
import mumage.mumagebackend.domain.User;
import mumage.mumagebackend.dto.UserJoinDto;
import mumage.mumagebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
public class UserController {

    private final UserService UserService;

    @Autowired
    public UserController(UserService Userervice) {
        this.UserService = Userervice;
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<MessageDto> joinMember(@Valid @RequestBody UserJoinDto userJoinDto) {

        User user = UserService.join(userJoinDto);
        MessageDto messageDto = new MessageDto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        messageDto.setStatus(HttpStatus.OK.value());
        messageDto.setMessage("회원 가입 성공");
        messageDto.setData(user);
        return new ResponseEntity<>(messageDto, headers, HttpStatus.OK);

    }

    @GetMapping(value = "/signup/id/{loginId}")
    public ResponseEntity<MessageDto> validateDuplicateLoginId(@PathVariable String loginId) {

        MessageDto messageDto = new MessageDto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        if (UserService.existLoginId(loginId)) {
            boolean existLoginId = false;

            messageDto.setStatus(HttpStatus.BAD_REQUEST.value());
            messageDto.setMessage("중복 아이디 존재");
            messageDto.setData(existLoginId);
            return new ResponseEntity<>(messageDto, headers, HttpStatus.BAD_REQUEST);

        } else {
            boolean existLoginId = true;

            messageDto.setStatus(HttpStatus.OK.value());
            messageDto.setMessage("중복 아이디 없음");
            messageDto.setData(existLoginId);
            return new ResponseEntity<>(messageDto, headers, HttpStatus.OK);

        }
    }

    @GetMapping(value = "/signup/nickname/{nickname}")
    public ResponseEntity<MessageDto> validateDuplicateNickname(@PathVariable String nickname) {

        MessageDto messageDto = new MessageDto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        if (UserService.existNickname(nickname)) {
            boolean existLoginId = false;

            messageDto.setStatus(HttpStatus.BAD_REQUEST.value());
            messageDto.setMessage("중복 닉네임 존재");
            messageDto.setData(existLoginId);
            return new ResponseEntity<>(messageDto, headers, HttpStatus.BAD_REQUEST);

        } else {
            boolean existLoginId = true;

            messageDto.setStatus(HttpStatus.OK.value());
            messageDto.setMessage("중복 닉네임 없음");
            messageDto.setData(existLoginId);
            return new ResponseEntity<>(messageDto, headers, HttpStatus.OK);

        }
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<MessageDto> withdrawMember(@PathVariable Long userId) {
        MessageDto messageDto = new MessageDto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        if (UserService.withdraw(userId)) {
            messageDto.setStatus(HttpStatus.OK.value());
            messageDto.setMessage("회원 탈퇴 성공");
            return new ResponseEntity<>(messageDto,headers,HttpStatus.OK);
        } else {
            messageDto.setStatus(HttpStatus.BAD_REQUEST.value());
            messageDto.setMessage("회원 탈퇴 실패");
            return new ResponseEntity<>(messageDto,headers,HttpStatus.BAD_REQUEST);
        }
    }

}