package com.example.demo.banque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/banque")
@CrossOrigin(origins = "https://frontspring.vercel.app")
public class BanqueController {
    private final BanqueService banqueService;

    @Autowired
    public BanqueController(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    @GetMapping
    public List<Banque> getBanques(){
        return banqueService.getBanques();
    }

    @PostMapping
    public void register(@RequestBody Banque banque){
        banqueService.addNewBanque(banque);
    }

    @DeleteMapping(path="{banqueId}")
    public void supprimerBanque(@PathVariable("banqueId") Long banqueId){
        banqueService.deleteBanque(banqueId);
    }

    @GetMapping(path="{banqueId}")
    public Optional<Banque> getBanque(@PathVariable("banqueId") Long banqueId){
        return banqueService.getBanque(banqueId);
    }

    @PutMapping(path = "{banqueId}")
    public void updateBanque(@PathVariable("banqueId") Long banqueId, @RequestBody Banque banque){
        banqueService.updateBanque(banqueId, banque);
    }
}
