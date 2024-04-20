package CS489.miu.ads.service;


import CS489.miu.ads.model.Dentist;

import java.util.List;

public interface DentistService {

    Dentist registerOne(Dentist dentist);

    void registerAll(List<Dentist> dentists);
}
