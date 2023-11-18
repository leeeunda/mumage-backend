package mumage.mumagebackend.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class UpdateUserDto {

    private String picture;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min=2,max=8,message = "이름은 최소 2글자에서 8글자까지 가능합니다.")
    private String name;
}
