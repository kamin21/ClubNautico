package Controllers;

import Entity.Salida;
import Services.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/salidas")
public class SalidaController {

    @Autowired
    private SalidaService salidaService;

    @GetMapping
    public List<Salida> getAllSalidas() {
        return salidaService.getAllSalidas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salida> getSalidaById(@PathVariable Long id) {
        return salidaService.getSalidaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Salida createSalida(@Valid @RequestBody Salida salida) {
        return salidaService.saveSalida(salida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salida> updateSalida(@PathVariable Long id, @Valid @RequestBody Salida salidaDetails) {
        return ResponseEntity.ok(salidaService.updateSalida(id, salidaDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalida(@PathVariable Long id) {
        salidaService.deleteSalida(id);
        return ResponseEntity.noContent().build();
    }
}
