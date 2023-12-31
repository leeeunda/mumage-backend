package mumage.mumagebackend.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class LoginUserDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞게 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min=3,max=15,message = "최소 3글자에서 최대 15글자까지 가능합니다.")
    private String password;
}
