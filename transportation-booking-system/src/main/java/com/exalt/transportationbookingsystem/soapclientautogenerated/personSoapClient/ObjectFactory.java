
package personSoapClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the personSoapClient package. 
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

    private final static QName _DeleteUserById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteUserById");
    private final static QName _NotFoundException_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "NotFoundException");
    private final static QName _DeleteDriverById_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteDriverById");
    private final static QName _DeleteUserByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteUserByIdResponse");
    private final static QName _DeleteDriverByIdResponse_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "deleteDriverByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: personSoapClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteDriverByIdResponse }
     * 
     */
    public DeleteDriverByIdResponse createDeleteDriverByIdResponse() {
        return new DeleteDriverByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteUserByIdResponse }
     * 
     */
    public DeleteUserByIdResponse createDeleteUserByIdResponse() {
        return new DeleteUserByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteDriverById }
     * 
     */
    public DeleteDriverById createDeleteDriverById() {
        return new DeleteDriverById();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link DeleteUserById }
     * 
     */
    public DeleteUserById createDeleteUserById() {
        return new DeleteUserById();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteUserById")
    public JAXBElement<DeleteUserById> createDeleteUserById(DeleteUserById value) {
        return new JAXBElement<DeleteUserById>(_DeleteUserById_QNAME, DeleteUserById.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDriverById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteDriverById")
    public JAXBElement<DeleteDriverById> createDeleteDriverById(DeleteDriverById value) {
        return new JAXBElement<DeleteDriverById>(_DeleteDriverById_QNAME, DeleteDriverById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteUserByIdResponse")
    public JAXBElement<DeleteUserByIdResponse> createDeleteUserByIdResponse(DeleteUserByIdResponse value) {
        return new JAXBElement<DeleteUserByIdResponse>(_DeleteUserByIdResponse_QNAME, DeleteUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDriverByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", name = "deleteDriverByIdResponse")
    public JAXBElement<DeleteDriverByIdResponse> createDeleteDriverByIdResponse(DeleteDriverByIdResponse value) {
        return new JAXBElement<DeleteDriverByIdResponse>(_DeleteDriverByIdResponse_QNAME, DeleteDriverByIdResponse.class, null, value);
    }

}
