package spring.oyuncakci.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.oyuncakci.Entity.Oyuncak;
import spring.oyuncakci.Service.OyuncakService;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/oyuncaklar")
public class OyuncakController {

    private final OyuncakService oyuncakService;

    public OyuncakController(OyuncakService oyuncakService) {
        this.oyuncakService = oyuncakService;
    }

    @PostMapping("/ekle")
    public ResponseEntity<Oyuncak> ekle(@RequestBody Oyuncak oyuncak) {
        Oyuncak ekleOyuncak = oyuncakService.ekle(oyuncak);
        return new ResponseEntity<>(ekleOyuncak, HttpStatus.CREATED);
    }

    @GetMapping("/getir/{id}")
    public ResponseEntity<Oyuncak> getir(@PathVariable Long id) {
        return oyuncakService.getir(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/sil/{id}")
    public ResponseEntity<String> sil(@PathVariable Long id) {
        oyuncakService.sil(id);
        return ResponseEntity.ok("Oyuncak başarıyla silindi.");
    }

    @PutMapping("/guncelle/{id}")
    public ResponseEntity<Oyuncak> guncelle(@PathVariable Long id, @RequestBody Oyuncak oyuncak) {
        return ResponseEntity.ok(oyuncakService.guncelle(id, oyuncak));
    }

    @GetMapping("/listele")
    public List<Oyuncak> listele() {
        return oyuncakService.listele();
    }
}
