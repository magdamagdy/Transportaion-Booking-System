package REST_WebServices.Controllers.VehicleController;

import Models.Vehicle.DTO.PlaneDTO;
import REST_WebServices.Services.VehicleService.PlaneService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/plane")
public class PlaneController {

    PlaneService planeService = new PlaneService();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
//    @JsonIgnoreProperties(ignoreUnknown = true)
    public Response addPlane(PlaneDTO plane){
        try {
            planeService.AddPlane(plane);
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
    public Response updatePlane(PlaneDTO plane){
        try{
            String result = planeService.UpdatePlane(plane);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"Plane not found").build();
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
            String result = port.deletePlaneById(id);
            return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }
}
