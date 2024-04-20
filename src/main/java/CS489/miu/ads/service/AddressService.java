package CS489.miu.ads.service;


import CS489.miu.ads.dto.response.AddressPatientResponse;
import CS489.miu.ads.model.Address;

import java.util.List;

public interface AddressService {

    Address register(Address address);
     void registerAll(List<Address> addresses);
    List<AddressPatientResponse> findAll();

    List<AddressPatientResponse> findAllWithPatient();


}
