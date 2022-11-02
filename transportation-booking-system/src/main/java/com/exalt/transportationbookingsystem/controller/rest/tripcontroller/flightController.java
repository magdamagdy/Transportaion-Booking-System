package com.exalt.transportationbookingsystem.controller.rest.tripcontroller;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.service.rest.tripservice.FlightService;
import com.exalt.transportationbookingsystem.service.rest.tripservice.flightServiceImpl;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/flight")
public class flightController {
    private final String nullWarningMsg = "Posted null value object or null id";
    private final String notFoundWarningMsg = "Object not found when searching by id";
    private final String internalServerErrorMsg = "Internal server error";
    private final String alreadyExistWarningMsg = "Flight already exist in user flight list";

    private static final Logger LOGGER = LoggerFactory.getLogger(flightController.class);

    FlightService flightService = new flightServiceImpl();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFlight(FlightDTO flight){
        try {
            return Response.ok(flightService.addFlight(flight)).build();
        }
        catch (NullValueException e){
            LOGGER.warn(nullWarningMsg);
            return Response.status(400, e.getMessage()).build();
        }
        catch (AlreadyExistException e){
            LOGGER.warn(alreadyExistWarningMsg);
            return Response.status(406,e.getMessage()).build();
        }
        catch (Exception e)
        {
            LOGGER.info(internalServerErrorMsg);
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFlight(FlightDTO flight){
        try{
            return Response.ok(flightService.updateFlight(flight)).build();
        }
        catch (NullValueException e){
            LOGGER.warn(nullWarningMsg);
            return Response.status(400, e.getMessage()).build();
        }
        catch (NotFoundException e){
            LOGGER.warn(notFoundWarningMsg);
            return Response.status(404, e.getMessage()).build();
        }
        catch (Exception e){
            LOGGER.info(internalServerErrorMsg);
            return Response.serverError().build();
        }
    }


    //Calling soap client at this method
    @DELETE
    @Path("/delete/{id}")
    public Response deleteFlight(@PathParam("id") int id){
        try {
            tripSoapClient.TripSoapClientService service = new tripSoapClient.TripSoapClientService();//class
            tripSoapClient.TripSoapClient port = service.getTripSoapClientPort();//interface
            port.deleteFlightById(id);
            return Response.ok().build();
        }
        catch (tripSoapClient.NotFoundException_Exception e){
            LOGGER.warn(notFoundWarningMsg);
            return Response.status(404, e.getMessage()).build();
        }
        catch (Exception e)
        {
            LOGGER.info(internalServerErrorMsg);
            return Response.serverError().build();
        }
    }
}
