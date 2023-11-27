package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Especialidad;
import org.example.model.Incidente;
import org.example.model.Tecnico;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class RankingTecnicosService implements Serializable {

    @Id
    private Long idRankingTecnicos;

    @OneToMany(mappedBy = "tecnicoResuelve")
    private List<Incidente> incidentesResueltos;

    public Tecnico obtenerTecnicoMasIncidentesResueltosUltimosDias(int dias) {
        return incidentesResueltos.stream()
                .filter(incidente -> incidente.getFechaResolucion() != null &&
                        incidente.getFechaResolucion().isAfter(LocalDate.now().minusDays(dias)))
                .collect(Collectors.groupingBy(Incidente::getTecnicoResuelve, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Tecnico obtenerTecnicoMasIncidentesEspecialidadUltimosDias(Especialidad especialidad, int dias) {
        return incidentesResueltos.stream()
                .filter(incidente -> incidente.getFechaResolucion() != null &&
                        incidente.getFechaResolucion().isAfter(LocalDate.now().minusDays(dias)) &&
                        incidente.getTecnicoResuelve().getEspecialidades().contains(especialidad))
                .collect(Collectors.groupingBy(Incidente::getTecnicoResuelve, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Tecnico obtenerTecnicoMasRapido() {
        return incidentesResueltos.stream()
                .filter(incidente -> incidente.getFechaResolucion() != null)
                .min(Comparator.comparing(Incidente::getFechaResolucion))
                .map(Incidente::getTecnicoResuelve)
                .orElse(null);
    }
}
