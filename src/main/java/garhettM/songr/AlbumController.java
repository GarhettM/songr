package garhettM.songr;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @Autowired
    public AlbumRepository albumRepository;

    @Autowired
    public SongRepository songRepository;

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imgUrl, String songTitle, int trackNumber, int songLength) {
        Album newAlbum = new Album(title, artist, songCount, length, imgUrl);

        Song newSong = new Song(songTitle, trackNumber, songLength, newAlbum);
        newAlbum.song.add(newSong);

        albumRepository.save(newAlbum);
        songRepository.save(newSong);

        return new RedirectView("/albums");
    }

    @GetMapping("/albums")
    public String showAlbum(Model albumMod) {
        ArrayList<Album> allTheThings = (ArrayList<Album>) albumRepository.findAll();
        albumMod.addAttribute("albums", allTheThings);
        return "albums";
    }
}