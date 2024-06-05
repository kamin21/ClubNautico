package Services;

import Entity.Patron;
import Repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrones() {
        return patronRepository.findAll();
    }

    public Optional<Patron> getPatronById(Long id) {
        return patronRepository.findById(id);
    }

    public Patron savePatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, Patron patronDetails) {
        Patron patron = patronRepository.findById(id).orElseThrow(() -> new RuntimeException("Patron no encontrado"));
        patron.setNombre(patronDetails.getNombre());
        patron.setApellidoPatron(patronDetails.getApellidoPatron());
        patron.setBarco(patronDetails.getBarco());
        return patronRepository.save(patron);
    }

    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
