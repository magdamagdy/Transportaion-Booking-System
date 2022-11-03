package com.exalt.transportationbookingsystem.controller.rest.vehiclecontroller;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.service.rest.vehicleservice.BusService;
import com.exalt.transportationbookingsystem.service.rest.vehicleservice.BusServiceImpl;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Bus controller.
 */
@Path("/bus")
public class BusController {

    private final String nullWarningMsg = "Posted null value object or null id";
    private final String notFoundWarningMsg = "Object not found when searching by id";
    private final String internalServerErrorMsg = "Internal server error";
    private static final Logger LOGGER = LoggerFactory.getLogger(BusController.class);
    /**
     * The Bus service.
     */
    BusService busService = new BusServiceImpl();

    /**
     * Create bus response.
     *
     * @param bus the bus
     * @return the response
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBus(BusDTO bus){
        try {
            return Response.ok(busService.addBus(bus)).build();
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
     * Update bus response.
     *
     * @param bus the bus
     * @return the response
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBus(BusDTO bus){
        try{
            return Response.ok(busService.updateBus(bus)).build();
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
     * Delete bus response.
     * Calling soap client at this method
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deleteBus(@PathParam("id") int id){
        try {
            vehicleSoapClient.VehicleSoapClientService service = new vehicleSoapClient.VehicleSoapClientService();//class
            vehicleSoapClient.VehicleSoapClient port = service.getVehicleSoapClientPort();//interface
            port.deleteBusById(id);
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
