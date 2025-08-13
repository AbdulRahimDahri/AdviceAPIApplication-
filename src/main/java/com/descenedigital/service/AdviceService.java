package com.descenedigital.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.descenedigital.dto.AdviceDTO;
import com.descenedigital.mapper.AdviceMapper;
import com.descenedigital.model.Advice;
import com.descenedigital.repo.AdviceRepo;

import jakarta.transaction.Transactional;

@Service
public class AdviceService {
	

    private final AdviceRepo repo;

    public AdviceService(AdviceRepo repo) {
        this.repo = repo;
    }

    public List<AdviceDTO> findAll() {
        return repo.findAll().stream().map(AdviceMapper::toDTO).collect(Collectors.toList());
    }

    public AdviceDTO findById(Long id) {
        Advice a = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Advice not found"));
        return AdviceMapper.toDTO(a);
    }

    public AdviceDTO create(Advice advice) {
        Advice saved = repo.save(advice);
        return AdviceMapper.toDTO(saved);
    }

    public AdviceDTO update(Long id, Advice advice) {
        Advice existing = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Advice not found"));
        existing.setMessage(advice.getMessage());
        repo.save(existing);
        return AdviceMapper.toDTO(existing);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Advice not found");
        }
        repo.deleteById(id);
    }

    @Transactional
    public AdviceDTO rate(Long id, int value) {
        Advice a = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Advice not found"));
        a.addRating(value);
        repo.save(a);
        return AdviceMapper.toDTO(a);
    }

    public List<AdviceDTO> getTopRated(int limit) {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(Advice::getAverageRating).reversed())
                .limit(Math.max(0, limit))
                .map(AdviceMapper::toDTO)
                .collect(Collectors.toList());
    }


}