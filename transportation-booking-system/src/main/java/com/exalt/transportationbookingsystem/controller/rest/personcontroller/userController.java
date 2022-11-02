package com.exalt.transportationbookingsystem.controller.rest.personcontroller;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.service.rest.personservice.UserService;
import com.exalt.transportationbookingsystem.service.rest.personservice.userServiceImpl;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The type User controller.
 */
@Path("/user")
public class userController {
    private final String nullWarningMsg = "Posted null value object or null id";
    private final String notFoundWarningMsg = "Object not found when searching by id";
    private final String internalServerErrorMsg = "Internal server error";
    private static final Logger LOGGER = LoggerFactory.getLogger(userController.class);
    /**
     * The User service.
     */
    UserService userService = new userServiceImpl();

    /**
     * Create user response.
     *
     * @param user the user
     * @return the response
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO user){
        try {
            return Response.ok(userService.addUser(user)).build();
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
     * Update user response.
     *
     * @param user the user
     * @return the response
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(UserDTO user){
        try{
            return Response.ok(userService.updateUser(user)).build();
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
     * Delete user response.
     * Calling soap client at this method
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") int id){
        try {
            personSoapClient.PersonSoapClientService service = new personSoapClient.PersonSoapClientService();//class
            personSoapClient.PersonSoapClient port = service.getPersonSoapClientPort();//interface
            port.deleteUserById(id);
            return Response.ok().build();
        }
        catch (personSoapClient.NotFoundException_Exception e){
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
