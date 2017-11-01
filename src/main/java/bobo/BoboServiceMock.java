package bobo;

import common.JsonResponse;
import common.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

public class BoboServiceMock implements BoboService{

    @Override
    public JsonResponse request(RequestDoctor data) {
//        RequestDoctor fake = new RequestDoctor();
//        fake.setEmail("dinamariana@gmail.com");
//        fake.setAddress("Laziiza");
//        fake.setLatitude(73.32);
//        fake.setLongitude(31.344);
//        fake.setCategory("otak");
//        fake.setComplaint("nyeri otak");
//        fake.setNote("rumah dekat laziiza");
//        fake.setStatus(0);

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Didindong");
        doctor.setPhone("087775891221");
        doctor.setSpec("Spesialis Artificial Neuron Network");
        doctor.setEmail("didindong@gmail.com");
        doctor.setGender("P");
        doctor.setBirthdate(19972609);

        List<Doctor> result = new ArrayList<>();
        result.add(doctor);
        JsonResponse response = new JsonResponse();
        response.setStatus(ResponseMessage.SUCCESS);
        response.setMessage(ResponseMessage.REQUEST_ACCEPTED);
        response.setData(result);
        return response;
    }
}
