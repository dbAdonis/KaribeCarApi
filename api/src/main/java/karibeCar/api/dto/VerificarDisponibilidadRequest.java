package karibeCar.api.dto;

import java.time.LocalDateTime;

public class VerificarDisponibilidadRequest {
    private int carId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Getters y setters
    public int getCarId() {
        return carId;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
