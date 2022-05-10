package com.in28minutes.soap.webservices.soapcoursemanagement.soap;

import com.in28minutes.soap.courses.*;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.exceptions.CourseNotFoundException;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class CourseDetailsEndpoint {

    @Autowired
    CourseDetailsService service;

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        Course course = service.findById(request.getId());

        if(course == null)
            throw new CourseNotFoundException("Invalid course id " + request.getId());

        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        response.setCourseDetails(maoCourse(course));
        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
        List<CourseDetails> courses = service.findAll().stream().map(c -> maoCourse(c)).collect(Collectors.toList());

        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        response.getCourseDetails().addAll(courses);
        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse processCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {
        CourseDetailsService.Status status = service.deleteById(request.getId());

        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        response.setStatus(mapStatus(status));
        return response;
    }

    private Status mapStatus(CourseDetailsService.Status status) {
        if(status == CourseDetailsService.Status.FAILURE){
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

    private CourseDetails maoCourse(Course course) {
        CourseDetails details = new CourseDetails();
        details.setId(course.getId());
        details.setName(course.getName());
        details.setDescription(course.getDescription());
        return details;
    }
}
