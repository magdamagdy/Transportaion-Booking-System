package REST_WebServices.Controllers.TripController;

import Models.Trip.DTO.TrainTripDTO;
import REST_WebServices.Services.TripService.TrainTripService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/trainTrip")
public class TrainTripController {
    TrainTripService trainTripService =new TrainTripService();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTrainTrip(TrainTripDTO trainTrip){
        try {
            trainTripService.AddTrainTrip(trainTrip);
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
    public Response updateTrainTrip(TrainTripDTO trainTrip){
        try{
            String result = trainTripService.UpdateTrainTrip(trainTrip);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"TrainTrip not found").build();
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
    public Response deleteTrainTrip(@PathParam("id") int id){
        try {
            TripSoapClient.TripSoapClientServiceService service = new TripSoapClient.TripSoapClientServiceService();//class
            TripSoapClient.TripSoapClientService port = service.getTripSoapClientServicePort();//interface
            String result = port.deleteTrainTripById(id);
            return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }
}
