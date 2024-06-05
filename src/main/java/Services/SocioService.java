package Services;

import Entity.Socio;
import Repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Optional<Socio> getSocioById(Long id) {
        return socioRepository.findById(id);
    }

    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    public Socio updateSocio(Long id, Socio socioDetails) {
        Socio socio = socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio no encontrado"));
        socio.setNombre(socioDetails.getNombre());
        socio.setApellidos(socioDetails.getApellidos());
        socio.setDireccion(socioDetails.getDireccion());
        return socioRepository.save(socio);
    }

    public void deleteSocio(Long id) {
        socioRepository.deleteById(id);
    }
}