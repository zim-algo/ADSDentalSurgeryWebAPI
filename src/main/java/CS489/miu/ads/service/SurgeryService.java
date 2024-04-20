package CS489.miu.ads.service;

import CS489.miu.ads.model.Surgery;

import java.util.List;

public interface SurgeryService {

    void registerAll(List<Surgery> surgeries);

    Surgery registerOne(Surgery surgery);
}
