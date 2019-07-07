/**
 * @author: Johnny PT
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.DtoBase;
import edu.umss.storeservice.model.Promotions;
import edu.umss.storeservice.repository.PromotionsRepository;
import edu.umss.storeservice.repository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionsServiceImpl implements PromotionsService {
    private final PromotionsRepository repository;

    public PromotionsServiceImpl(PromotionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Promotions> findAll() {
        List<Promotions> promotions=new ArrayList<>();
        this.repository.findAll().forEach(promotions::add);
        return promotions;
    }

    @Override
    public Promotions findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Promotions save(Promotions model) {
        return  this.repository.save(model);
    }

    @Override
    public Promotions saveAndFlush(Promotions model) {
        return null;
    }

    @Override
    public Promotions patch(DtoBase dto, Promotions model) {
        return null;
    }

    @Override
    public List<Promotions> saveAll(Iterable<Promotions> models) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Byte[] getBytes(MultipartFile file) {
        return new Byte[0];
    }

    @Override
    public Page<Promotions> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Promotions> findAll(String filter) {
        return null;
    }
}