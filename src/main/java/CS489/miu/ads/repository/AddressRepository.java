package CS489.miu.ads.repository;

import CS489.miu.ads.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a LEFT JOIN FETCH a.patient ORDER BY a.city DESC ")
    List<Address> findAllAddressesWithPatientsSortedByCity();
}
