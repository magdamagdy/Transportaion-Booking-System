package REST_WebServices.Controllers.VehicleController;

import Models.Vehicle.DTO.TrainDTO;
import REST_WebServices.Services.VehicleService.TrainService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/train")
public class TrainController {

    TrainService trainService = new TrainService();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
//    @JsonIgnoreProperties(ignoreUnknown = true)
    public Response addTrain(TrainDTO train){
        try {
            trainService.AddTrain(train);
            return Response.ok().build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }


    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTrain(TrainDTO train){
        try{
            String result = trainService.UpdateTrain(train);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"Train not found").build();
            }
        }
        catch (Exception e){
            return Response.serverError().build();
        }
        return null;
    }

    //Calling soap client at this method
    @DELETE
    @Path("/delete/{id}")
    public Response deletePlane(@PathParam("id") int id){
        try {
            VehicleSoapClient.VehicleSoapClientServiceService service = new VehicleSoapClient.VehicleSoapClientServiceService();//class
            VehicleSoapClient.VehicleSoapClientService port = service.getVehicleSoapClientServicePort();//interface
            String result = port.deleteTrainById(id);
            return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }
}
