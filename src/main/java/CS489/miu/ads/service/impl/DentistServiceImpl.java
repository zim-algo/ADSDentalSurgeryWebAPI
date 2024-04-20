package CS489.miu.ads.service.impl;

import CS489.miu.ads.model.Dentist;
import CS489.miu.ads.repository.DentistRepository;
import CS489.miu.ads.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private DentistRepository repo;

    public DentistServiceImpl(DentistRepository repo) {
        this.repo = repo;
    }

    @Override
    public Dentist registerOne(Dentist dentist) {
        return repo.save(dentist);
    }

    @Override
    public void registerAll(List<Dentist> dentists) {
        repo.saveAll(dentists);
    }
}
