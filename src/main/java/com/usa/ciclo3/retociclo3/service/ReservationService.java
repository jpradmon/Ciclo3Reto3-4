/**
 * Paquete en donde tenemos nuestro pryecto
 */
package com.usa.ciclo3.retociclo3.service;

/**
 * Importamos los paquetes necesarios
 */
import com.usa.ciclo3.retociclo3.model.Reservation;
import com.usa.ciclo3.retociclo3.reports.CountClient;
import com.usa.ciclo3.retociclo3.reports.ReservationStatus;
import com.usa.ciclo3.retociclo3.repository.ReservationRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Anotación para declarar el tipo service Creamos la clase ReservationService
 *
 * @author Jorge E Prada M
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Método que nos trae todas las reservaciones
     *
     * @return
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * Método que nos trae una única reservación
     *
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    /**
     * Metodo para validar y guardar una nueva reservación
     *
     * @param reservation
     * @return una reservación
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> tmpReservation = reservationRepository.getReservation(reservation.getIdReservation());
            if (tmpReservation.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Método para validar y actualizar una reservación
     *
     * @param reservation
     * @return la reservacion para actualizar
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Método para validar y eliminar una reservación
     *
     * @param id la llave de la tabla reservation
     * @return un valor boolean
     */
    public boolean deleteReservation(int id) {
        Boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
/**
 * Método que nos entrega el valor de las reservaciones
 * para formar el reporte
 * @return 
 */
    public ReservationStatus getReservationStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationStatus(completed.size(), cancelled.size());
    }
    /**
 * Método que nos entrega las fechas de las reservaciones
 * para formar el reporte
 * @return 
 */
    public List<Reservation> getReservationPeriod(String dateOne, String dateTwo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(dateOne);
            Date endDate = dateFormat.parse(dateTwo);
            if (startDate.before(endDate)) {
                return reservationRepository.getReservationPeriod(startDate, endDate);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
    /**
     * Este método nos entrega la cuenta de los clientes.
     * @return 
     */
    public List<CountClient> getTopClients() {
        return reservationRepository.getTopClient();
    }
}
