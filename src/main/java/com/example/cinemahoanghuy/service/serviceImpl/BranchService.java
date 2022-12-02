package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.dto.TBranchDTO;
import com.example.cinemahoanghuy.entity.Branch;
import com.example.cinemahoanghuy.entity.Theater;
import com.example.cinemahoanghuy.repo.BranchRepository;
import com.example.cinemahoanghuy.repo.TheaterRepository;
import com.example.cinemahoanghuy.service.IBranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService implements IBranchService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    @Transactional
    public void addTheaterToBranch(String nameTheater, String nameBranch) {
        Optional<Branch> branch = branchRepository.findByName(nameBranch);
        Optional<Theater> theater = theaterRepository.findByName(nameTheater);
        if (branch.isPresent() && theater.isPresent()){
//            branch.get().getTheaters().add(theater.get());
            theater.get().setBranch(branch.get());
        }

    }
    @Override
    public List<TBranchDTO> findALl() {
        return branchRepository
                .findAll()
                .stream()
                .map(branch -> modelMapper.map(branch, TBranchDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TBranchDTO> findById(Long id) {
        return Optional.ofNullable(modelMapper.map(branchRepository.findById(id), TBranchDTO.class));
    }

    @Override
    public TBranchDTO save(TBranchDTO tBranchDTO) {
        return branchRepository.save(modelMapper.map(tBranchDTO, Branch.class)) != null ? tBranchDTO : null;
    }

    @Override
    public void delete(TBranchDTO tBranchDTO) {

    }

    @Override
    public void delete(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public TBranchDTO update(TBranchDTO tBranchDTO) {
        return null;
    }


}
