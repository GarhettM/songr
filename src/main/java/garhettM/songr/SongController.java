package garhettM.songr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @PostMapping("/song")
    public RedirectView addSong(String title, int trackNumber, int length, long albumId) {
        Album alb = albumRepository.getOne(albumId);
        Song son = new Song(title, trackNumber, length, alb);
        songRepository.save(son);

        return new RedirectView("/albums");
    }
}
