package REST_WebServices.Controllers.TripController;

import Models.Trip.DTO.BusTripDTO;
import REST_WebServices.Services.TripService.BusTripService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/busTrip")
public class BusTripController {

    BusTripService busTripService =new BusTripService();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBusTrip(BusTripDTO busTrip){
        try {
            busTripService.AddBusTrip(busTrip);
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
    public Response updateBusTrip(BusTripDTO busTrip){
        try{
            String result = busTripService.UpdateBusTrip(busTrip);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"BusTrip not found").build();
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
    public Response deleteBusTrip(@PathParam("id") int id){
        try {
            TripSoapClient.TripSoapClientServiceService service = new TripSoapClient.TripSoapClientServiceService();//class
            TripSoapClient.TripSoapClientService port = service.getTripSoapClientServicePort();//interface
            String result = port.deleteBusTripById(id);
            return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }
}
