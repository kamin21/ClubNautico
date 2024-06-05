package Controllers;

import Entity.Barco;
import Services.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/barcos")
public class BarcoController {

    @Autowired
    private BarcoService barcoService;

    @GetMapping
    public List<Barco> getAllBarcos() {
        return barcoService.getAllBarcos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barco> getBarcoById(@PathVariable Long id) {
        return barcoService.getBarcoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Barco createBarco(@Valid @RequestBody Barco barco) {
        return barcoService.saveBarco(barco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barco> updateBarco(@PathVariable Long id, @Valid @RequestBody Barco barcoDetails) {
        return ResponseEntity.ok(barcoService.updateBarco(id, barcoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarco(@PathVariable Long id) {
        barcoService.deleteBarco(id);
        return ResponseEntity.noContent().build();
    }
}