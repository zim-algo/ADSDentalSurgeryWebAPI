package CS489.miu.ads.service.impl;

import CS489.miu.ads.model.Appointment;
import CS489.miu.ads.repository.AppointmentRepository;
import CS489.miu.ads.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerAll(List<Appointment> appointments) {
        repo.saveAll(appointments);
    }

    @Override
    public List<Appointment> getAll() {
        return repo.findAll();
    }

}
