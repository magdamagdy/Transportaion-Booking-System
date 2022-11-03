
package vehicleSoapClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the vehicleSoapClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteBusById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteBusById");
    private final static QName _DeletePlaneByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deletePlaneByIdResponse");
    private final static QName _DeletePlaneById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deletePlaneById");
    private final static QName _RestrictDeleteException_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "RestrictDeleteException");
    private final static QName _NotFoundException_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "NotFoundException");
    private final static QName _DeleteBusByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteBusByIdResponse");
    private final static QName _DeleteTrainByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteTrainByIdResponse");
    private final static QName _DeleteTrainById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteTrainById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: vehicleSoapClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteTrainById }
     * 
     */
    public DeleteTrainById createDeleteTrainById() {
        return new DeleteTrainById();
    }

    /**
     * Create an instance of {@link DeleteTrainByIdResponse }
     * 
     */
    public DeleteTrainByIdResponse createDeleteTrainByIdResponse() {
        return new DeleteTrainByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteBusByIdResponse }
     * 
     */
    public DeleteBusByIdResponse createDeleteBusByIdResponse() {
        return new DeleteBusByIdResponse();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link RestrictDeleteException }
     * 
     */
    public RestrictDeleteException createRestrictDeleteException() {
        return new RestrictDeleteException();
    }

    /**
     * Create an instance of {@link DeletePlaneById }
     * 
     */
    public DeletePlaneById createDeletePlaneById() {
        return new DeletePlaneById();
    }

    /**
     * Create an instance of {@link DeletePlaneByIdResponse }
     * 
     */
    public DeletePlaneByIdResponse createDeletePlaneByIdResponse() {
        return new DeletePlaneByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteBusById }
     * 
     */
    public DeleteBusById createDeleteBusById() {
        return new DeleteBusById();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteBusById")
    public JAXBElement<DeleteBusById> createDeleteBusById(DeleteBusById value) {
        return new JAXBElement<DeleteBusById>(_DeleteBusById_QNAME, DeleteBusById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePlaneByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deletePlaneByIdResponse")
    public JAXBElement<DeletePlaneByIdResponse> createDeletePlaneByIdResponse(DeletePlaneByIdResponse value) {
        return new JAXBElement<DeletePlaneByIdResponse>(_DeletePlaneByIdResponse_QNAME, DeletePlaneByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePlaneById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deletePlaneById")
    public JAXBElement<DeletePlaneById> createDeletePlaneById(DeletePlaneById value) {
        return new JAXBElement<DeletePlaneById>(_DeletePlaneById_QNAME, DeletePlaneById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestrictDeleteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "RestrictDeleteException")
    public JAXBElement<RestrictDeleteException> createRestrictDeleteException(RestrictDeleteException value) {
        return new JAXBElement<RestrictDeleteException>(_RestrictDeleteException_QNAME, RestrictDeleteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteBusByIdResponse")
    public JAXBElement<DeleteBusByIdResponse> createDeleteBusByIdResponse(DeleteBusByIdResponse value) {
        return new JAXBElement<DeleteBusByIdResponse>(_DeleteBusByIdResponse_QNAME, DeleteBusByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTrainByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteTrainByIdResponse")
    public JAXBElement<DeleteTrainByIdResponse> createDeleteTrainByIdResponse(DeleteTrainByIdResponse value) {
        return new JAXBElement<DeleteTrainByIdResponse>(_DeleteTrainByIdResponse_QNAME, DeleteTrainByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTrainById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteTrainById")
    public JAXBElement<DeleteTrainById> createDeleteTrainById(DeleteTrainById value) {
        return new JAXBElement<DeleteTrainById>(_DeleteTrainById_QNAME, DeleteTrainById.class, null, value);
    }

}
