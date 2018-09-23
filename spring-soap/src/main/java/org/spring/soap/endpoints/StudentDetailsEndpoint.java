package org.spring.soap.endpoints;

import org.spring.soap.students.GetStudentDetailsRequest;
import org.spring.soap.students.GetStudentDetailsResponse;
import org.spring.soap.students.StudentDetails;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentDetailsEndpoint {

	@PayloadRoot(namespace = "http://soap.spring.org/students", localPart = "GetStudentDetailsRequest")
	@ResponsePayload
	public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {
		GetStudentDetailsResponse response = new GetStudentDetailsResponse();

		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId(request.getId());
		studentDetails.setName("Adam");
		studentDetails.setPassportNumber("E1234567");

		response.setStudentDetails(studentDetails);

		return response;
	}

	
}