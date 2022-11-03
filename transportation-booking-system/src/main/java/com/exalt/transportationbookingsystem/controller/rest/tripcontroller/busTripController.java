package com.exalt.transportationbookingsystem.controller.rest.tripcontroller;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.service.rest.tripservice.BusTripService;
import com.exalt.transportationbookingsystem.service.rest.tripservice.BusTripServiceImpl;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Bus trip controller.
 */
@Path("/busTrip")
public class BusTripController {

    private final String nullWarningMsg = "Posted null value object or null id";
    private final String notFoundWarningMsg = "Object not found when searching by id";
    private final String internalServerErrorMsg = "Internal server error";
    private final String alreadyExistWarningMsg = "Trip already exist in user trip list";

    private static final Logger LOGGER = LoggerFactory.getLogger(BusTripController.class);
    /**
     * The Bus trip service.
     */
    BusTripService busTripService = new BusTripServiceImpl();

    /**
     * Create bus trip response.
     *
     * @param busTrip the bus trip
     * @return the response
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBusTrip(BusTripDTO busTrip){
        try {
            return Response.ok(busTripService.addBusTrip(busTrip)).build();
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


    /**
     * Update bus trip response.
     *
     * @param busTrip the bus trip
     * @return the response
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBusTrip(BusTripDTO busTrip){
        try{
            return Response.ok(busTripService.updateBusTrip(busTrip)).build();
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

    /**
     * Delete bus trip response.
     * Calling soap client at this method
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deleteBusTrip(@PathParam("id") int id){
        try {
            tripSoapClient.TripSoapClientService service = new tripSoapClient.TripSoapClientService();//class
            tripSoapClient.TripSoapClient port = service.getTripSoapClientPort();//interface
            port.deleteBusTripById(id);
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
