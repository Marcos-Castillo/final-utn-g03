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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class RankingTecnicosService implements Serializable {

    private List<Incidente> incidentesResueltos;

    public RankingTecnicosService(List<Incidente> incidentesResueltos){
        this.incidentesResueltos = incidentesResueltos;
    }

    public Tecnico obtenerTecnicoMasIncidentesResueltosUltimosDias(int dias) {
        return incidentesResueltos.stream()
                .filter(incidente -> incidente.getFechaResolucion() != null &&
                        incidente.getFechaResolucion().isAfter(LocalDate.now().minusDays(dias)))
                .collect(Collectors.groupingBy(Incidente::getTecnicoResuelve, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseGet(() -> crearNuevoTecnico("Técnico sin incidentes resueltos en los últimos " + dias + " días"));
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
                .orElseGet(() -> crearNuevoTecnico("Técnico sin incidentes resueltos en la especialidad " + especialidad.getNombreEspecialidad() + " en los últimos " + dias + " días"));
    }

    public Tecnico obtenerTecnicoMasRapido() {
        return incidentesResueltos.stream()
                .filter(incidente -> incidente.getFechaResolucion() != null)
                .min(Comparator.comparing(Incidente::getFechaResolucion))
                .map(Incidente::getTecnicoResuelve)
                .orElseGet(() -> crearNuevoTecnico("Técnico sin incidentes resueltos rápidos"));
    }

    private Tecnico crearNuevoTecnico(String nombre) {
        Tecnico tecnico = new Tecnico();

        tecnico.setNombre(nombre);

        return tecnico;
    }
}
