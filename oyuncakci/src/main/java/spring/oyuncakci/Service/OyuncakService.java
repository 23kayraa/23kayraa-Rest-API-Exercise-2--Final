package spring.oyuncakci.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.oyuncakci.Entity.Oyuncak;
import spring.oyuncakci.Repository.OyuncakRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OyuncakService {
    @Autowired
    private OyuncakRepository oyuncakRepository;

    public Oyuncak ekle(Oyuncak oyuncak) {
        return oyuncakRepository.save(oyuncak);
    }

    public Optional<Oyuncak> getir(Long id) {
        return oyuncakRepository.findById(id);
    }

    public void sil(Long id) {
        oyuncakRepository.deleteById(id);
    }

    public Oyuncak guncelle(Long id, Oyuncak oyuncakGuncellenmis) {
        return oyuncakRepository.findById(id)
                .map(oyuncak -> {
                    oyuncak.setAlisTarihi(oyuncakGuncellenmis.getAlisTarihi());
                    oyuncak.setAlisFiyati(oyuncakGuncellenmis.getAlisFiyati());
                    oyuncak.setAd(oyuncakGuncellenmis.getAd());
                    oyuncak.setTur(oyuncakGuncellenmis.getTur());
                    oyuncak.setDesi(oyuncakGuncellenmis.getDesi());
                    oyuncak.setNotlar(oyuncakGuncellenmis.getNotlar());
                    return oyuncakRepository.save(oyuncak);
                }).orElseGet(() -> {
                    oyuncakGuncellenmis.setId(id);
                    return oyuncakRepository.save(oyuncakGuncellenmis);
                });
    }

    public List<Oyuncak> listele() {
        return oyuncakRepository.findAll();
    }
}
