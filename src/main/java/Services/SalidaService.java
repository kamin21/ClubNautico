package Services;

import Entity.Salida;
import Repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalidaService {

    @Autowired
    private SalidaRepository salidaRepository;

    public List<Salida> getAllSalidas() {
        return salidaRepository.findAll();
    }

    public Optional<Salida> getSalidaById(Long id) {
        return salidaRepository.findById(id);
    }

    public Salida saveSalida(Salida salida) {
        return salidaRepository.save(salida);
    }

    public Salida updateSalida(Long id, Salida salidaDetails) {
        Salida salida = salidaRepository.findById(id).orElseThrow(() -> new RuntimeException("Salida no encontrada"));
        salida.setFechaHoraSalida(salidaDetails.getFechaHoraSalida());
        salida.setDestino(salidaDetails.getDestino());
        salida.setBarco(salidaDetails.getBarco());
        return salidaRepository.save(salida);
    }

    public void deleteSalida(Long id) {
        salidaRepository.deleteById(id);
    }
}
