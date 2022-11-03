
package tripSoapClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tripSoapClient package. 
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

    private final static QName _DeleteBusTripById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteBusTripById");
    private final static QName _DeleteFlightById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteFlightById");
    private final static QName _DeleteFlightByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteFlightByIdResponse");
    private final static QName _NotFoundException_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "NotFoundException");
    private final static QName _DeleteBusTripByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteBusTripByIdResponse");
    private final static QName _DeleteTrainTripById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteTrainTripById");
    private final static QName _DeleteTrainTripByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteTrainTripByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tripSoapClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteTrainTripById }
     * 
     */
    public DeleteTrainTripById createDeleteTrainTripById() {
        return new DeleteTrainTripById();
    }

    /**
     * Create an instance of {@link DeleteTrainTripByIdResponse }
     * 
     */
    public DeleteTrainTripByIdResponse createDeleteTrainTripByIdResponse() {
        return new DeleteTrainTripByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteBusTripByIdResponse }
     * 
     */
    public DeleteBusTripByIdResponse createDeleteBusTripByIdResponse() {
        return new DeleteBusTripByIdResponse();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link DeleteFlightByIdResponse }
     * 
     */
    public DeleteFlightByIdResponse createDeleteFlightByIdResponse() {
        return new DeleteFlightByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteBusTripById }
     * 
     */
    public DeleteBusTripById createDeleteBusTripById() {
        return new DeleteBusTripById();
    }

    /**
     * Create an instance of {@link DeleteFlightById }
     * 
     */
    public DeleteFlightById createDeleteFlightById() {
        return new DeleteFlightById();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusTripById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteBusTripById")
    public JAXBElement<DeleteBusTripById> createDeleteBusTripById(DeleteBusTripById value) {
        return new JAXBElement<DeleteBusTripById>(_DeleteBusTripById_QNAME, DeleteBusTripById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFlightById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteFlightById")
    public JAXBElement<DeleteFlightById> createDeleteFlightById(DeleteFlightById value) {
        return new JAXBElement<DeleteFlightById>(_DeleteFlightById_QNAME, DeleteFlightById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFlightByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteFlightByIdResponse")
    public JAXBElement<DeleteFlightByIdResponse> createDeleteFlightByIdResponse(DeleteFlightByIdResponse value) {
        return new JAXBElement<DeleteFlightByIdResponse>(_DeleteFlightByIdResponse_QNAME, DeleteFlightByIdResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusTripByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteBusTripByIdResponse")
    public JAXBElement<DeleteBusTripByIdResponse> createDeleteBusTripByIdResponse(DeleteBusTripByIdResponse value) {
        return new JAXBElement<DeleteBusTripByIdResponse>(_DeleteBusTripByIdResponse_QNAME, DeleteBusTripByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTrainTripById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteTrainTripById")
    public JAXBElement<DeleteTrainTripById> createDeleteTrainTripById(DeleteTrainTripById value) {
        return new JAXBElement<DeleteTrainTripById>(_DeleteTrainTripById_QNAME, DeleteTrainTripById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTrainTripByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteTrainTripByIdResponse")
    public JAXBElement<DeleteTrainTripByIdResponse> createDeleteTrainTripByIdResponse(DeleteTrainTripByIdResponse value) {
        return new JAXBElement<DeleteTrainTripByIdResponse>(_DeleteTrainTripByIdResponse_QNAME, DeleteTrainTripByIdResponse.class, null, value);
    }

}
