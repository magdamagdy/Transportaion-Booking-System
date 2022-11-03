package com.exalt.transportationbookingsystem.controller.rest.vehiclecontroller;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.service.rest.vehicleservice.PlaneService;
import com.exalt.transportationbookingsystem.service.rest.vehicleservice.PlaneServiceImpl;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Plane controller.
 */
@Path("/plane")
public class PlaneController {

    private final String nullWarningMsg = "Posted null value object or null id";
    private final String notFoundWarningMsg = "Object not found when searching by id";
    private final String internalServerErrorMsg = "Internal server error";
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaneController.class);
    /**
     * The Plane service.
     */
    PlaneService planeService = new PlaneServiceImpl();

    /**
     * Add plane response.
     *
     * @param plane the plane
     * @return the response
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlane(PlaneDTO plane){
        try {
            return Response.ok(planeService.addPlane(plane)).build();
        }
        catch (NullValueException e)
        {
            LOGGER.warn(nullWarningMsg);
            return Response.status(400, e.getMessage()).build();
        }
        catch (Exception e)
        {
            LOGGER.info(internalServerErrorMsg);
            return Response.serverError().build();
        }
    }


    /**
     * Update plane response.
     *
     * @param plane the plane
     * @return the response
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlane(PlaneDTO plane){
        try{
            return Response.ok(planeService.updatePlane(plane)).build();
        }
        catch (NullValueException e)
        {
            LOGGER.warn(nullWarningMsg);
            return Response.status(400, e.getMessage()).build();
        }
        catch (NotFoundException e)
        {
            LOGGER.warn(notFoundWarningMsg);
            return Response.status(404,e.getMessage()).build();
        }
        catch (Exception e){
            LOGGER.info(internalServerErrorMsg);
            return Response.serverError().build();
        }
    }

    /**
     * Delete plane response.
     * Calling soap client at this method
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deletePlane(@PathParam("id") int id){
        try {
            vehicleSoapClient.VehicleSoapClientService service = new vehicleSoapClient.VehicleSoapClientService();//class
            vehicleSoapClient.VehicleSoapClient port = service.getVehicleSoapClientPort();//interface
            port.deletePlaneById(id);
            return Response.ok().build();
        }
        catch (vehicleSoapClient.NotFoundException_Exception e){
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
