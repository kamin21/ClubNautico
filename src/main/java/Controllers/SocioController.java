package Controllers;

import Entity.Socio;
import Services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping
    public List<Socio> getAllSocios() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Socio> getSocioById(@PathVariable Long id) {
        return socioService.getSocioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Socio createSocio(@Valid @RequestBody Socio socio) {
        return socioService.saveSocio(socio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Socio> updateSocio(@PathVariable Long id, @Valid @RequestBody Socio socioDetails) {
        return ResponseEntity.ok(socioService.updateSocio(id, socioDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocio(@PathVariable Long id) {
        socioService.deleteSocio(id);
        return ResponseEntity.noContent().build();
    }
}
