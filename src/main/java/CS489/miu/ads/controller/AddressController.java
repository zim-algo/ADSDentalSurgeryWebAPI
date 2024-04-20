package CS489.miu.ads.controller;

import CS489.miu.ads.dto.response.AddressPatientResponse;
import CS489.miu.ads.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AddressPatientResponse>> getAll(){
       // return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.findAllWithPatient());
    }
}
