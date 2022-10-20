
package VehicleSoapClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the VehicleSoapClient package. 
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

    private final static QName _DeleteBusByIdResponse_QNAME = new QName("http://Client.SOAP_WebServices/", "DeleteBusByIdResponse");
    private final static QName _DeletePlaneById_QNAME = new QName("http://Client.SOAP_WebServices/", "DeletePlaneById");
    private final static QName _DeletePlaneByIdResponse_QNAME = new QName("http://Client.SOAP_WebServices/", "DeletePlaneByIdResponse");
    private final static QName _DeleteTrainById_QNAME = new QName("http://Client.SOAP_WebServices/", "DeleteTrainById");
    private final static QName _DeleteBusById_QNAME = new QName("http://Client.SOAP_WebServices/", "DeleteBusById");
    private final static QName _DeleteTrainByIdResponse_QNAME = new QName("http://Client.SOAP_WebServices/", "DeleteTrainByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: VehicleSoapClient
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link DeleteBusByIdResponse }
     * 
     */
    public DeleteBusByIdResponse createDeleteBusByIdResponse() {
        return new DeleteBusByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteTrainById }
     * 
     */
    public DeleteTrainById createDeleteTrainById() {
        return new DeleteTrainById();
    }

    /**
     * Create an instance of {@link DeleteBusById }
     * 
     */
    public DeleteBusById createDeleteBusById() {
        return new DeleteBusById();
    }

    /**
     * Create an instance of {@link DeleteTrainByIdResponse }
     * 
     */
    public DeleteTrainByIdResponse createDeleteTrainByIdResponse() {
        return new DeleteTrainByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeleteBusByIdResponse")
    public JAXBElement<DeleteBusByIdResponse> createDeleteBusByIdResponse(DeleteBusByIdResponse value) {
        return new JAXBElement<DeleteBusByIdResponse>(_DeleteBusByIdResponse_QNAME, DeleteBusByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePlaneById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeletePlaneById")
    public JAXBElement<DeletePlaneById> createDeletePlaneById(DeletePlaneById value) {
        return new JAXBElement<DeletePlaneById>(_DeletePlaneById_QNAME, DeletePlaneById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePlaneByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeletePlaneByIdResponse")
    public JAXBElement<DeletePlaneByIdResponse> createDeletePlaneByIdResponse(DeletePlaneByIdResponse value) {
        return new JAXBElement<DeletePlaneByIdResponse>(_DeletePlaneByIdResponse_QNAME, DeletePlaneByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTrainById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeleteTrainById")
    public JAXBElement<DeleteTrainById> createDeleteTrainById(DeleteTrainById value) {
        return new JAXBElement<DeleteTrainById>(_DeleteTrainById_QNAME, DeleteTrainById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeleteBusById")
    public JAXBElement<DeleteBusById> createDeleteBusById(DeleteBusById value) {
        return new JAXBElement<DeleteBusById>(_DeleteBusById_QNAME, DeleteBusById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTrainByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeleteTrainByIdResponse")
    public JAXBElement<DeleteTrainByIdResponse> createDeleteTrainByIdResponse(DeleteTrainByIdResponse value) {
        return new JAXBElement<DeleteTrainByIdResponse>(_DeleteTrainByIdResponse_QNAME, DeleteTrainByIdResponse.class, null, value);
    }

}
