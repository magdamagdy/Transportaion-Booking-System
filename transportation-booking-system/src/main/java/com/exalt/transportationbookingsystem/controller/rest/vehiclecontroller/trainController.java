package com.exalt.transportationbookingsystem.controller.rest.vehiclecontroller;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.service.rest.vehicleservice.TrainService;
import com.exalt.transportationbookingsystem.service.rest.vehicleservice.trainServiceImpl;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Train controller.
 */
@Path("/train")
public class trainController {
    private final String nullWarningMsg = "Posted null value object or null id";
    private final String notFoundWarningMsg = "Object not found when searching by id";
    private final String internalServerErrorMsg = "Internal server error";
    private static final Logger LOGGER = LoggerFactory.getLogger(trainController.class);
    /**
     * The Train service.
     */
    TrainService trainService = new trainServiceImpl();

    /**
     * Add train response.
     *
     * @param train the train
     * @return the response
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTrain(TrainDTO train){
        try {

            return Response.ok(trainService.addTrain(train)).build();
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
     * Update train response.
     *
     * @param train the train
     * @return the response
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTrain(TrainDTO train){
        try{
            return Response.ok(trainService.updateTrain(train)).build();
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
     * Delete train response.
     * Calling soap client at this method
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deleteTrain(@PathParam("id") int id){
        try {
            vehicleSoapClient.VehicleSoapClientService service = new vehicleSoapClient.VehicleSoapClientService();//class
            vehicleSoapClient.VehicleSoapClient port = service.getVehicleSoapClientPort();//interface
            port.deleteTrainById(id);
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
