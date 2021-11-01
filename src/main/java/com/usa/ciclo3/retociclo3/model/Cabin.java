/**
 * Creación del paquete contenedor de nuestro programa
 */
package com.usa.ciclo3.retociclo3.model;
/**
 * Importación de librerias necesarias
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * Declaramos una entidad en donde asociamos a la base de datos cabin
 * @author Jorge E Prada M
 */
@Entity
@Table(name = "cabin")
/**
 * Creación de la clase Cabin
 */
public class Cabin implements Serializable {
    /**
     * Definimos cual es la llave primaria de la tabla
     * y la forma de autoincrmento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Campo llave primaria
     */
    private Integer id;
    /**
     * Campo nombre
     */
    private String name;
    /**
     * Campo marca
     */
    private String brand;
    /**
     * Campo cuartos
     */
    private Integer rooms;
    /**
     * Campo descripción
     */
    private String description;
    /**
     * Anotación para la relación entre tablas
     * Anotación para nombre de columna
     */
    @ManyToOne
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties("cabins")
     /**
     * Campo categoria tabla category
     */
    private Category category;
    /**
     * Anotación para la relación entre tablas
     * Creación de lista valores de tabla Message
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Message> messages;
     /**
     * Anotación para la relación entre tablas
     * Creación de lista valores de tabla Reservation
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Reservation> reservations;
    /**
     * Creación metodo get de id.
     * @return devuelve el valor de id
     */
    public Integer getId() {
        return id;
    }
    /**
     * Creación metodo set de id.
     * asigna el valor a id
     */
    public void setId(Integer id) {
        this.id = id;
    }
     /**
     * Creación metodo get de name.
     * @return devuelve el valor de name
     */
    public String getName() {
        return name;
    }
    /**
     * Creación metodo set de name.
     * asigna el valor a name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Creación metodo get de brand.
     * @return devuelve el valor de brand
     */
    public String getBrand() {
        return brand;
    }
    /**
     * Creación metodo set de brand.
     * asigna el valor a brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * Creación metodo get de rooms.
     * @return devuelve el valor de rooms
     */
    public Integer getRooms() {
        return rooms;
    }
    /**
     * Creación metodo set de rooms.
     * asigna el valor a rooms
     */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }
    /**
     * Creación metodo get de description.
     * @return devuelve el valor de description
     */
    public String getDescription() {
        return description;
    }
     /**
     * Creación metodo set de description.
     * asigna el valor a description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Creación metodo get de category.
     * @return devuelve el valor de category
     */
    public Category getCategory() {
        return category;
    }
     /**
     * Creación metodo set de category.
     * asigna el valor a category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * Creación metodo get de message.
     * @return devuelve el valor de message
     */
    public List<Message> getMessages() {
        return messages;
    }
     /**
     * Creación metodo set de message.
     * asigna el valor a message
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * Creación metodo get de reservations.
     * devuelve el valor de reservation
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
     /**
     * Creación metodo set de reservations.
     * asigna el valor a reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
