package bobo;

import common.JsonResponse;
import common.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

public class BoboServiceMock implements BoboService{

    @Override
    public JsonResponse request(RequestDoctor data) {
        Doctor doctor = new Doctor();
        doctor.setName("dr. H. Dina Marjani, Sp.OJ");
        doctor.setPhone("087775891221");
        doctor.setSpecialty("Spesialis Perut Mulas & Mencret");
        doctor.setEmail("congky@gmail.com");
        doctor.setGender("L");
        doctor.setBirthdate(19972609);

        List<Doctor> result = new ArrayList<>();
        result.add(doctor);
        JsonResponse response = new JsonResponse();
        return response
                .success(ResponseMessage.REQUEST_ACCEPTED)
                .data(result);
    }
}
