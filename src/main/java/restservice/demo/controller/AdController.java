package restservice.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.demo.dto.AdDto;
import restservice.demo.service.AdService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdController {

    private final AdService adService;
    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }
    @PostMapping("/add-ad")
    public ResponseEntity<String> addAd(@RequestBody AdDto adDto) {
        adService.addAd(adDto);
        return ResponseEntity.ok("Ad added successfully.");
    }

    @GetMapping("/get-ads")
    public ResponseEntity<List<AdDto>> getAllAds() {
        List<AdDto> adDtos = adService.getAllAds();
        return ResponseEntity.ok(adDtos);
    }

    @GetMapping("/get-ad/{id}")
    public ResponseEntity<AdDto> getAdById(@PathVariable Long id) {
        AdDto adDto = adService.getAdById(id);
        if (adDto != null) {
            return ResponseEntity.ok(adDto);
        } else {
            // Return a 404 Not Found response if the ad with the given ID is not found
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-ad/{id}")
    public ResponseEntity<String> deleteAdById(@PathVariable Long id) {
        boolean isDeleted = adService.deleteAdById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Ad deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
