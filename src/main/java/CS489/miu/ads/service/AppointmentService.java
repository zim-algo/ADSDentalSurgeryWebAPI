package CS489.miu.ads.service;

import CS489.miu.ads.model.Appointment;

import java.util.List;

public interface AppointmentService {

    void registerAll(List<Appointment> appointments);

    List<Appointment> getAll();
}
