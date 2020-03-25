package api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoApi {

    private List<Video> videoList;

    public VideoApi() {
        videoList = new ArrayList<>();
        videoList.add(new Video(1, "Wiadomości ze świata kryptowalut WIRUS POGŁĘBIA KRYZYS 18.03.20",
                "https://youtu.be/khmEFilgYWU"));
        videoList.add(new Video(2, "Jak uratować się przed kryzysem Sławomir Mentzen Rozmowy Konieczne 8",
                "https://youtu.be/AftZaFzCsuc"));
    }

    @GetMapping
    public ResponseEntity<List<Video>> getVideos() {
        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoByID(@PathVariable long id) {
        Optional<Video> first = videoList.stream().filter(video -> video.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity addVideo(@RequestBody Video video) {
        boolean add = videoList.add(video);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity modVideo(@RequestBody Video newVideo) {
        Optional<Video> first = videoList.stream().filter(video -> video.getId() == newVideo.getId()).findFirst();
        if (first.isPresent()) {
            videoList.remove(first.get());
            videoList.add(newVideo);
            return new ResponseEntity(first.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> removeVideo(@PathVariable long id) {
        Optional<Video> first = videoList.stream().filter(video -> video.getId() == id).findFirst();
        if (first.isPresent()) {
            videoList.remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}