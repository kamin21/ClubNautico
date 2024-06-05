package Services;

import Entity.Barco;
import Repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    public List<Barco> getAllBarcos() {
        return barcoRepository.findAll();
    }

    public Optional<Barco> getBarcoById(Long id) {
        return barcoRepository.findById(id);
    }

    public Barco saveBarco(Barco barco) {
        return barcoRepository.save(barco);
    }

    public Barco updateBarco(Long id, Barco barcoDetails) {
        Barco barco = barcoRepository.findById(id).orElseThrow(() -> new RuntimeException("Barco no encontrado"));
        barco.setMatricula(barcoDetails.getMatricula());
        barco.setNombre(barcoDetails.getNombre());
        barco.setNumeroAmarre(barcoDetails.getNumeroAmarre());
        barco.setCuota(barcoDetails.getCuota());
        barco.setSocio(barcoDetails.getSocio());
        return barcoRepository.save(barco);
    }

    public void deleteBarco(Long id) {
        barcoRepository.deleteById(id);
    }
}
