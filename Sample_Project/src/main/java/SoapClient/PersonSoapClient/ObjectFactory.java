
package PersonSoapClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PersonSoapClient package. 
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

    private final static QName _DeleteUserById_QNAME = new QName("http://Client.SOAP_WebServices/", "DeleteUserById");
    private final static QName _DeleteUserByIdResponse_QNAME = new QName("http://Client.SOAP_WebServices/", "DeleteUserByIdResponse");
    private final static QName _DeletDriverById_QNAME = new QName("http://Client.SOAP_WebServices/", "DeletDriverById");
    private final static QName _DeletDriverByIdResponse_QNAME = new QName("http://Client.SOAP_WebServices/", "DeletDriverByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PersonSoapClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteUserByIdResponse }
     * 
     */
    public DeleteUserByIdResponse createDeleteUserByIdResponse() {
        return new DeleteUserByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteUserById }
     * 
     */
    public DeleteUserById createDeleteUserById() {
        return new DeleteUserById();
    }

    /**
     * Create an instance of {@link DeletDriverById }
     * 
     */
    public DeletDriverById createDeletDriverById() {
        return new DeletDriverById();
    }

    /**
     * Create an instance of {@link DeletDriverByIdResponse }
     * 
     */
    public DeletDriverByIdResponse createDeletDriverByIdResponse() {
        return new DeletDriverByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeleteUserById")
    public JAXBElement<DeleteUserById> createDeleteUserById(DeleteUserById value) {
        return new JAXBElement<DeleteUserById>(_DeleteUserById_QNAME, DeleteUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeleteUserByIdResponse")
    public JAXBElement<DeleteUserByIdResponse> createDeleteUserByIdResponse(DeleteUserByIdResponse value) {
        return new JAXBElement<DeleteUserByIdResponse>(_DeleteUserByIdResponse_QNAME, DeleteUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletDriverById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeletDriverById")
    public JAXBElement<DeletDriverById> createDeletDriverById(DeletDriverById value) {
        return new JAXBElement<DeletDriverById>(_DeletDriverById_QNAME, DeletDriverById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletDriverByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Client.SOAP_WebServices/", name = "DeletDriverByIdResponse")
    public JAXBElement<DeletDriverByIdResponse> createDeletDriverByIdResponse(DeletDriverByIdResponse value) {
        return new JAXBElement<DeletDriverByIdResponse>(_DeletDriverByIdResponse_QNAME, DeletDriverByIdResponse.class, null, value);
    }

}
