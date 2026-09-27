package com.rushinga.fire.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fire_incidents")
public class FireIncident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Shared Incident Metadata
    private String ward;
    private String district;
    private String province;
    private LocalDateTime occurrenceDateTime;
    private String reporter;
    private String severity;
    private String status; // PENDING, APPROVED, REJECTED
    private Double latitude;
    private Double longitude;

    // 5 Mandatory Fire Indicators
    private Double areaBurnedHectares;
    private String suspectedCause; // Natural, Accidental, Deliberate
    private Integer injuriesOrFatalities;
    private Integer structuresDestroyed;
    private String fireStatus; // ACTIVE, CONTAINED, EXTINGUISHED

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public LocalDateTime getOccurrenceDateTime() { return occurrenceDateTime; }
    public void setOccurrenceDateTime(LocalDateTime occurrenceDateTime) { this.occurrenceDateTime = occurrenceDateTime; }

    public String getReporter() { return reporter; }
    public void setReporter(String reporter) { this.reporter = reporter; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getAreaBurnedHectares() { return areaBurnedHectares; }
    public void setAreaBurnedHectares(Double areaBurnedHectares) { this.areaBurnedHectares = areaBurnedHectares; }

    public String getSuspectedCause() { return suspectedCause; }
    public void setSuspectedCause(String suspectedCause) { this.suspectedCause = suspectedCause; }

    public Integer getInjuriesOrFatalities() { return injuriesOrFatalities; }
    public void setInjuriesOrFatalities(Integer injuriesOrFatalities) { this.injuriesOrFatalities = injuriesOrFatalities; }

    public Integer getStructuresDestroyed() { return structuresDestroyed; }
    public void setStructuresDestroyed(Integer structuresDestroyed) { this.structuresDestroyed = structuresDestroyed; }

    public String getFireStatus() { return fireStatus; }
    public void setFireStatus(String fireStatus) { this.fireStatus = fireStatus; }
}