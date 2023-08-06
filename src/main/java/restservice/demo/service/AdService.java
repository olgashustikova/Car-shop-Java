package restservice.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restservice.demo.dto.AdDto;
import restservice.demo.entity.Ad;
import restservice.demo.repository.AdRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdService {

    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public AdDto addAd(AdDto adDto) {
        Ad ad = new Ad();
        ad.setMake(adDto.getMake());
        ad.setModel(adDto.getModel());
        ad.setYear(adDto.getYear());
        ad.setPrice(adDto.getPrice());
        ad.setDescription(adDto.getDescription());
        ad.setTransmission(adDto.getTransmission());
        ad.setKilometres(adDto.getKilometres());
        ad.setBodyType(adDto.getBodyType());
        ad.setSellerType(adDto.getSellerType());

        Ad savedAd = adRepository.save(ad);

        // Convert the saved entity back to the DTO
        return new AdDto(savedAd.getMake(), savedAd.getModel(), savedAd.getYear(), savedAd.getPrice(), savedAd.getDescription(), savedAd.getTransmission(), savedAd.getKilometres(), savedAd.getBodyType(), savedAd.getSellerType());
    }
    public List<AdDto> getAllAds() {
        List<Ad> ads = adRepository.findAll();

        // Convert the list of Ad entities to a list of AdDto objects
        List<AdDto> adDtos = new ArrayList<>();
        for (Ad ad : ads) {
            AdDto adDto = new AdDto(ad.getMake(), ad.getModel(), ad.getYear(), ad.getPrice(), ad.getDescription(), ad.getTransmission(), ad.getKilometres(), ad.getBodyType(), ad.getSellerType());
            adDtos.add(adDto);
        }
        return adDtos;
    }

    public AdDto getAdById(Long id) {
        Optional<Ad> optionalAd = adRepository.findById(id);
        if (optionalAd.isPresent()) {
            Ad ad = optionalAd.get();
            return new AdDto(ad.getMake(), ad.getModel(), ad.getYear(), ad.getPrice(), ad.getDescription(), ad.getTransmission(), ad.getKilometres(), ad.getBodyType(), ad.getSellerType());
        }
        return null;
    }
    public boolean deleteAdById(Long id) {
        if (adRepository.existsById(id)) {
            adRepository.deleteById(id);
            return true;
        }
        return false;
    }









        }
