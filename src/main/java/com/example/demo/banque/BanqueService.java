package com.example.demo.banque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BanqueService {
    private final BanqueRepository banqueRepository;

    @Autowired
    public BanqueService(BanqueRepository banqueRepository) {
        this.banqueRepository = banqueRepository;
    }

    public List<Banque> getBanques(){
        return banqueRepository.findAll();
    }

    public void addNewBanque(Banque banque) {
        System.out.println(banque);
        banqueRepository.save(banque);
    }

    public void deleteBanque(Long banqueId) {
        if(!banqueRepository.existsById(banqueId)){
            throw new IllegalStateException("banque doesn't exists");
        }
        banqueRepository.deleteById(banqueId);
    }

    public Optional<Banque> getBanque(Long banqueId) {
        return banqueRepository.findById(banqueId);
    }

    public void updateBanque(Long banqueId, Banque banque) {
        banque.setId(banqueId);
        banqueRepository.save(banque);
    }
}
