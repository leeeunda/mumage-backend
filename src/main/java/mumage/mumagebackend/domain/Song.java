package mumage.mumagebackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue
    @Column(name = "song_id")
    public Long songId; //기본키


    @Column(nullable = false)
    public String songName; //노래이름
    public String songUrl; //노래 재생 Url
    public String singer; //가수명
    public String lyrics; //가사
    public String albumName; //앨범 이름


    @Builder
    public Song(String songName, String singer, String songUrl, String albumName){
        this.songUrl=songUrl;
        this.songName=songName;
        this.albumName=albumName;
        this.singer=singer;
    }

}